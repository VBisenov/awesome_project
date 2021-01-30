package com.example.awesome_project.repository;

import com.example.awesome_project.model.Writer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class WriterRepository implements JpaRepository<Writer, UUID> {
    @Override
    public List<Writer> findAll() {
        return null;
    }

    @Override
    public List<Writer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Writer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Writer> findAllById(Iterable<UUID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Writer writer) {

    }

    @Override
    public void deleteAll(Iterable<? extends Writer> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Writer> S save(S s) {
        return null;
    }

    @Override
    public <S extends Writer> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Writer> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Writer> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Writer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Writer getOne(UUID uuid) {
        return null;
    }

    @Override
    public <S extends Writer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Writer> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Writer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Writer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Writer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Writer> boolean exists(Example<S> example) {
        return false;
    }
}
