package common.model;

/**
 * 下拉框VO
 *
 * @author yzt
 */
public class DropdownVO {
    private String label;
    private String value;


    public DropdownVO(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DropdownVO() {
    }
}
