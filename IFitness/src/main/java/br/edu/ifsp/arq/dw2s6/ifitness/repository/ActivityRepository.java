package br.edu.ifsp.arq.dw2s6.ifitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.dw2s6.ifitness.domain.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
