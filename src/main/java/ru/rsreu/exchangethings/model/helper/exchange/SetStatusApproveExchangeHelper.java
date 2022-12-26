package ru.rsreu.exchangethings.model.helper.exchange;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ExchangeStatusEnum;
import ru.rsreu.exchangethings.model.datalayer.entity.RequestEntity;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.ItemService;
import ru.rsreu.exchangethings.model.service.RequestService;
import ru.rsreu.exchangethings.view.beans.ItemBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetStatusApproveExchangeHelper implements Helper {
    RequestService requestService = RequestService.instance;
    ItemService itemService = ItemService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int id_exchange = Integer.parseInt(request.getParameter("id_exchange"));
        RequestEntity requestEntity = requestService.getById(id_exchange);
        ItemBean itemReceiver = itemService.getItemByIdWithOwner(requestEntity.getItemReceiverID());
        ItemBean itemSender = itemService.getItemByIdWithOwner(requestEntity.getItemSenderID());
        itemService.updateItemUserOwner(itemReceiver.getId(), itemSender.getOwner().getId());
        itemService.updateItemUserOwner(itemSender.getId(), itemReceiver.getOwner().getId());
        requestService.updateRequestStatus(id_exchange, ExchangeStatusEnum.END.order);
    }
}
