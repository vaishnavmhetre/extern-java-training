package Support.Splitter.Contract;

import Support.Splitter.Contract.Support.SplitterContract;

/**
 * Contract bounding for split of String type input expression
 *
 * @param <ReturnType> - Type of value to be returned as whole after split
 */
public interface StringSplitterContract<ReturnType> extends SplitterContract<String, String, ReturnType> {
}
