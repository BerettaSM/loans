package com.ramon.loans.core.domain.usecases;

public interface UseCase<RequestModel, ResponseModel> {

    ResponseModel execute(RequestModel payload);

}
