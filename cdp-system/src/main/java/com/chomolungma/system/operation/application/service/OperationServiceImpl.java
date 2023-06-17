package com.chomolungma.system.operation.application.service;

import com.chomolungma.system.operation.domain.assembler.OperationAssembler;
import com.chomolungma.system.operation.domain.entity.Operation;
import com.chomolungma.system.operation.domain.repository.IOperationRepository;
import com.chomolungma.system.operation.interfaces.param.OperationDTO;
import com.chomolungma.core.exception.BusinessRuntimeException;
import org.springframework.stereotype.Service;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/

@Service
public class OperationServiceImpl implements OperationService{
    private final IOperationRepository iOperationRepository;
    
    public OperationServiceImpl(IOperationRepository iOperationRepository){
        this.iOperationRepository = iOperationRepository;
    }

}
