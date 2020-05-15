package wooteco.subway.admin.exception;

public class NoStationNameExistsException extends IllegalArgumentException {
	public NoStationNameExistsException() {
		super("해당역이 존재하지 않아요.");
	}
}
