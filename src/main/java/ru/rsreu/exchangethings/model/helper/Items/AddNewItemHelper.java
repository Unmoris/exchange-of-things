package ru.rsreu.exchangethings.model.helper.Items;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.ImageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.InputStream;

public class AddNewItemHelper implements Helper {

    ImageService imageService = ImageService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        try {
            Part filePart = request.getPart("image"); // Retrieves <input type="file" name="file">
            InputStream fileContent = filePart.getInputStream();
            String imageName = imageService.saveIconImage(fileContent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
