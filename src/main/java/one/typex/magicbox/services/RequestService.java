package one.typex.magicbox.services;

import one.typex.magicbox.dto.CoordinateDto;
import one.typex.magicbox.dto.CreateRequestDto;
import one.typex.magicbox.dto.CreateRequestResponse;
import one.typex.magicbox.dto.RequestDto;
import one.typex.magicbox.entities.Category;
import one.typex.magicbox.entities.Request;
import one.typex.magicbox.repositories.CategoryRepo;
import one.typex.magicbox.repositories.RequestRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    private final RequestRepo requestRepo;
    private final CategoryRepo categoryRepo;

    public RequestService(RequestRepo requestRepo, CategoryRepo categoryRepo) {
        this.requestRepo = requestRepo;
        this.categoryRepo = categoryRepo;
    }


    public List<RequestDto> getPointsByCategory(long categoryId) {
        return requestRepo.findByCategoryId(categoryId)
                .stream().map(it ->
                        new RequestDto(
                                it.getCategoryId(),
                                it.getSummary(),
                                it.getCreatedAt(),
                                new CoordinateDto(it.getLon(), it.getLat())
                        )
                ).toList();
    }

    public String getTextById(long id) {
        Optional<Request> request = requestRepo.findById(id);
        if (request.isPresent())
            return request.get().getContent();
        return "";
    }


    public void createRequest(CreateRequestDto newRequest) {
        Optional<Category> categoryOpt = categoryRepo.findByName(newRequest.getSummary());
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            Request request = new Request();

            request.setCategoryId(category.getId());
            request.setSummary(newRequest.getSummary());
            request.setContent(newRequest.getText());
            var coordinates = newRequest.getCoordinate();
            request.setLon(coordinates.getLon());
            request.setLat(coordinates.getLat());
            requestRepo.save(request);
        }
    }
}
