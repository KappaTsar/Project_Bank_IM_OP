package pl.edu.wszib.bank.dao.impl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.edu.wszib.bank.dao.ITransactionDAO;
import pl.edu.wszib.bank.model.TransactionDetails;

import java.util.List;
import java.util.Optional;

public class TransactionDAOStub implements ITransactionDAO {
    @Override
    public TransactionDetails findTransactionDetailsById(int id) {
        return null;
    }

    @Override
    public List<TransactionDetails> findAll() {
        return null;
    }

    @Override
    public List<TransactionDetails> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TransactionDetails> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<TransactionDetails> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(TransactionDetails transactionDetails) {

    }

    @Override
    public void deleteAll(Iterable<? extends TransactionDetails> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TransactionDetails> S save(S s) {
        return null;
    }

    @Override
    public <S extends TransactionDetails> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<TransactionDetails> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends TransactionDetails> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<TransactionDetails> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TransactionDetails getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends TransactionDetails> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TransactionDetails> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TransactionDetails> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TransactionDetails> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TransactionDetails> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TransactionDetails> boolean exists(Example<S> example) {
        return false;
    }
}
