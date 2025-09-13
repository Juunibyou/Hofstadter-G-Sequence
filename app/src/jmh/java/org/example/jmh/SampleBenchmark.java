package org.example.jmh;

import org.example.Hofstadter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 2)
@Warmup(iterations = 2)
public class SampleBenchmark {
  @Benchmark
  @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
  public void sayHelloBenchmark(Blackhole bh) {
      Hofstadter hofstadter = new Hofstadter();
      String output = hofstadter.gSequence(1);
      bh.consume(output);
  }
}
