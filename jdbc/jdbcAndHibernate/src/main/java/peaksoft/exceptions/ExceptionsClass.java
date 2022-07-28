package peaksoft.exceptions;

public class ExceptionsClass {

    public class SomethingWentWrong extends RuntimeException{
        public SomethingWentWrong() {
        }

        public SomethingWentWrong(String message) {
            super(message);
        }
    }

}
