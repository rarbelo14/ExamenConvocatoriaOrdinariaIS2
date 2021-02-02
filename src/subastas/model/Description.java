package subastas.model;

import java.util.List;


class Description {
    private final String text;
    private final List<Image> images; 

    public Description(String text, List<Image> images) {
        this.text = text;
        this.images = images;
    }

    public String getText() {
        return text;
    }

    public List<Image> getImages() {
        return images;
    }

    public String ImagestoString() {
        String res = "";
        for(Image image : images){
            res += image.getName() + ", ";
        }
        return res.substring(0, res.length()-2);
    }
    
    
    
}
