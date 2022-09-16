package com.chomolungma.system.org.domain.repository;

import com.chomolungma.system.org.pojo.Org;

public interface IOrgRepository {
    Org find(Long id);
}
