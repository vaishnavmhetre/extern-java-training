package Support.Splitter.Contract.Support;

/**
 * Contract bounding for Splitting of expression
 *
 * @param <ToSplitDataType> - Type of expression to be taken in
 * @param <DelimiterType> - Type of Delimiter to be taken in
 * @param <ReturnType> - Type of value to be returned as whole after split
 */
public interface SplitterContract<ToSplitDataType, DelimiterType, ReturnType> {

    ReturnType split(ToSplitDataType input, DelimiterType delimiter);

}
