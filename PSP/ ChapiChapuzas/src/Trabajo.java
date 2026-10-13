public class Trabajo {
    private String sourcePath;
    private  String language;
    private  String destinationPath;
    public Trabajo(String sourcePath, String language, String destinationPath) {
        this.sourcePath = sourcePath;
        this.language = language;
        this.destinationPath = destinationPath;
    }
    public String getSourcePath() {
        return sourcePath;
    }
    public String getLanguage() {
        return language;
    }
    public String getDestinationPath() {
        return destinationPath;
    }
    
}
