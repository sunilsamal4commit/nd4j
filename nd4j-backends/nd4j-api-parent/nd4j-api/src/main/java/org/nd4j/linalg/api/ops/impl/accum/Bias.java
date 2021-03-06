/*-
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 *
 */

package org.nd4j.linalg.api.ops.impl.accum;

import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.NoOpNameFoundException;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseAccumulation;

import java.util.List;

/**
 * Calculate a bias
 *
 * @author Adam Gibson
 */
public class Bias extends BaseAccumulation {

    private double mean;

    public Bias(SameDiff sameDiff, DifferentialFunction i_v, int[] dimensions, double mean) {
        super(sameDiff, i_v, dimensions);
        this.mean = mean;
    }

    public Bias(SameDiff sameDiff, DifferentialFunction i_v, DifferentialFunction i_v2, int[] dimensions, double mean) {
        super(sameDiff, i_v, i_v2, dimensions);
        this.mean = mean;
    }

    public Bias() {}

    public Bias(INDArray x, INDArray y, INDArray z, long n) {
        super(x, y, z, n);
    }

    public Bias(INDArray x, INDArray y, long n) {
        this(x, y, x, n);
    }

    public Bias(INDArray x) {
        super(x);
    }

    public Bias(INDArray x, INDArray y) {
        super(x, y);
    }

    @Override
    public int opNum() {
        return 2;
    }

    @Override
    public String opName() {
        return "bias";
    }


    @Override
    public boolean isPassThrough() {
        return false;
    }


    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> f1) {
        return null;
    }

    @Override
    public String onnxName() {
        throw new NoOpNameFoundException("No onnx op opName found for " +  opName());
    }

    @Override
    public String tensorflowName() {
        throw new NoOpNameFoundException("No tensorflow op opName found for " +  opName());
    }

}
