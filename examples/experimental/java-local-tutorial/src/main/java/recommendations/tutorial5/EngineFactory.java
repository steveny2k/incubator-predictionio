/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.predictionio.examples.java.recommendations.tutorial5;

import org.apache.predictionio.examples.java.recommendations.tutorial3.DataSource;
import org.apache.predictionio.examples.java.recommendations.tutorial1.TrainingData;
import org.apache.predictionio.examples.java.recommendations.tutorial1.Query;

import org.apache.predictionio.controller.java.IJavaEngineFactory;
import org.apache.predictionio.controller.java.JavaSimpleEngine;
import org.apache.predictionio.controller.java.JavaSimpleEngineBuilder;

public class EngineFactory implements IJavaEngineFactory {
  public JavaSimpleEngine<TrainingData, Object, Query, Float, Float> apply() {
    return new JavaSimpleEngineBuilder<
      TrainingData, Object, Query, Float, Float> ()
      .dataSourceClass(DataSource.class)
      .preparatorClass() // Use default Preparator
      .addAlgorithmClass("MyMahoutRecommendationAlgo", MahoutAlgorithm.class)
      .servingClass() // Use default Serving
      .build();
  }
}
