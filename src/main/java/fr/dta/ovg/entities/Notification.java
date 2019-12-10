package fr.dta.ovg.entities;

public class Notification extends EntityBase {

    private String label;
    private boolean app;
    private boolean mail;
    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }
    /**
     * @param label the label to set
     */
    public void setLabel(final String label) {
        this.label = label;
    }
    /**
     * @return the app
     */
    public boolean isApp() {
        return app;
    }
    /**
     * @param app the app to set
     */
    public void setApp(final boolean app) {
        this.app = app;
    }
    /**
     * @return the mail
     */
    public boolean isMail() {
        return mail;
    }
    /**
     * @param mail the mail to set
     */
    public void setMail(final boolean mail) {
        this.mail = mail;
    }


}
