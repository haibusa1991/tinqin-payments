package com.tinqin.payments.api.base;


public interface Processor<R extends ProcessorResult, I extends ProcessorInput> {

    R process(I input);
}
