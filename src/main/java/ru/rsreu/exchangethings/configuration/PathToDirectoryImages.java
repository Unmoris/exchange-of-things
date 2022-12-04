package ru.rsreu.exchangethings.configuration;

public class PathToDirectoryImages {

    private static final String NAME_DIRECTORY = "images";
    private static String path;

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        PathToDirectoryImages.path = path +  NAME_DIRECTORY;
    }
}
