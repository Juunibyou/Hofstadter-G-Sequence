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

  @Param({"5", "10", "15", "20", "25"}) // inputs to test
  public int n;

  private Hofstadter hofstadter;
  private int[] memory;

  @Setup(Level.Invocation)
  public void setup() {
    hofstadter = new Hofstadter();
    memory = new int[n + 1];
    for (int i = 0; i <= n; i++) memory[i] = -1;
  }

  @Benchmark
  public void testNaive(Blackhole bh) {
    bh.consume(hofstadter.gNaive(n));
  }

  @Benchmark
  public void testMemoized(Blackhole bh) {
    bh.consume(hofstadter.gMemorized(n, memory));
  }
}
