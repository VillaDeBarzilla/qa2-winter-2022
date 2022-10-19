package homework1;

public class Tea {
    //tea description
    private String color;
    private String taste;
    private boolean teabag;
    private boolean looseLeaf;
    private boolean granulated;

    //----------SETTERS/GETTERS-----------

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public boolean isTeabag() {
        return teabag;
    }

    public void setTeabag(boolean teabag) {
        this.teabag = teabag;
    }

    public boolean isLooseLeaf() {
        return looseLeaf;
    }

    public void setLooseLeaf(boolean looseLeaf) {
        this.looseLeaf = looseLeaf;
    }

    public boolean isGranulated() {
        return granulated;
    }

    public void setGranulated(boolean granulated) {
        this.granulated = granulated;
    }
}
