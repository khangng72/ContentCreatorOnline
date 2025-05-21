package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.model.UserReportChapter;
import org.springframework.data.jpa.domain.Specification;

public class UserReportChapterSpecifications {

    public static Specification<UserReportChapter> hasResolveState(String resolveState) {
        return (root, query, criteriaBuilder) -> {
            if (resolveState == null || resolveState.equalsIgnoreCase("all")) {
                return null; // means no filtering
            }
            return criteriaBuilder.equal(root.get("resolve_state"), resolveState);
        };
    }
}


