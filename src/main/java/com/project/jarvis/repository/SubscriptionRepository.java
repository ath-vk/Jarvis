package com.project.jarvis.repository;

import com.project.jarvis.entity.Subscription;
import com.project.jarvis.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.Optional;
import java.util.Set;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    /*
     * Get the current active subscription
     * */
    Optional<Subscription> findByUserIdAndStatusIn(Long userId, Set<SubscriptionStatus> active);
}
