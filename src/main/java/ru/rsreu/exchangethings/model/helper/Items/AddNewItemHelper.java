package ru.rsreu.exchangethings.model.helper.Items;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.ImageService;
import ru.rsreu.exchangethings.model.service.ItemService;
import ru.rsreu.exchangethings.security.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class AddNewItemHelper implements Helper {

    private ImageService imageService = ImageService.instance;
    private SecurityService securityService = SecurityService.instance;

    private ItemService itemService = ItemService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        String title = request.getParameter("title_item");
        ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(description);
        System.out.println(new String(description.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        System.out.println(title);
        int userId = securityService.getTokenInfo(request).getUserId();
        try {
            Part filePart = request.getPart("image"); // Retrieves <input type="file" name="file">
            InputStream fileContent = filePart.getInputStream();
            String imageName = imageService.saveIconImage(fileContent);
            itemService.saveItem(title,imageName, description,userId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
