package hcmut.contentCreatorOnline.exception;

import org.springframework.http.HttpStatus;

enum OccurredPoint {
    AI("ai"),
    APP("app"),
    AUTH("auth"),
    DB("db"),
    UNEXPECTED("unexpected");

    private final String value;

    OccurredPoint(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

public class ErrorConst {
    public static final ErrorConstParams RESOURCE_EXIST = new ErrorConstParams(
            HttpStatus.BAD_REQUEST,
            "400000",
            OccurredPoint.APP.toString(),
            "Resource is exist");

    public static final ErrorConstParams UNEXPECTED_ERROR = new ErrorConstParams(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "500000",
            OccurredPoint.UNEXPECTED.toString(),
            "Unexpected error occurred");

    public static final ErrorConstParams INTERNAL_DATA_INSERT_FAIL = new ErrorConstParams(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "5000001",
            OccurredPoint.DB.toString(),
            "Insert data failed");

    public static final ErrorConstParams INTERNAL_DATA_UPDATE_FAIL = new ErrorConstParams(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "5000002",
            OccurredPoint.DB.toString(),
            "Update data failed");

    public static final ErrorConstParams INTERNAL_DATA_SELECT_FAIL = new ErrorConstParams(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "5000003",
            OccurredPoint.DB.toString(),
            "Select data failed");

    public static final ErrorConstParams INTERNAL_DATA_DELETE_FAIL = new ErrorConstParams(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "5000004",
            OccurredPoint.DB.toString(),
            "Delete data failed");

}
