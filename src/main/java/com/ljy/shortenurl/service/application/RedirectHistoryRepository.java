package com.ljy.shortenurl.service.application;

import com.ljy.shortenurl.service.domain.RedirectHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedirectHistoryRepository extends JpaRepository<RedirectHistory, Long> {
}
