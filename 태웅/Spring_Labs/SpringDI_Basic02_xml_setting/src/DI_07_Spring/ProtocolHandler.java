package DI_07_Spring;

import java.util.List;

//Filter 사용하기
public class ProtocolHandler {

	private List<MyFilter> filters; //주소값이 올 수 있다...

	public List<MyFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<MyFilter> filters) {
		this.filters = filters;
	}
	
	public int filter_length() {
		return this.filters.size();
	}
}
