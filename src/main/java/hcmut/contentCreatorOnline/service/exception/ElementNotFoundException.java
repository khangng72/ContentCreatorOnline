package hcmut.contentCreatorOnline.service.exception;

public class ElementNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ElementNotFoundException(final Class<?> entity){
        super(String.format("Cannot find entity of class [%s]", entity.getName()));
    }
}
