package app12;

import java.util.List;

public class BeerService {
	private BeerDAO dao = new BeerDAO(); // TODO: singleton 적용
	
	public BeerDTO getBeerPage(int page, int pagePer) {
		int totalCount = dao.countAll();
		int totalPage = totalCount / pagePer;
		totalPage += totalCount % pagePer == 0 ? 0 : 1;
		
		List<Beer> list = dao.getAll(pagePer, pagePer * (page - 1));
		
		BeerDTO dto = BeerDTO.builder()
			.totalPages(totalPage)
			.currentPage(page)
			.itemsPerPage(pagePer)
			.items(list)
			.build();
		return dto;
	}
}



