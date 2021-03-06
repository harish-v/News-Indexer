/**
 * 
 */
package edu.buffalo.cse.irf14.analysis;


/**
 * Factory class for instantiating a given TokenFilter
 * @author nikhillo
 *
 */
public class TokenFilterFactory {
	
	private static final TokenFilterFactory tff = new TokenFilterFactory();
	
	private TokenFilterFactory(){
		
	}
	/**
	 * Static method to return an instance of the factory class.
	 * Usually factory classes are defined as singletons, i.e. 
	 * only one instance of the class exists at any instance.
	 * This is usually achieved by defining a private static instance
	 * that is initialized by the "private" constructor.
	 * On the method being called, you return the static instance.
	 * This allows you to reuse expensive objects that you may create
	 * during instantiation
	 * @return An instance of the factory
	 */
	public static TokenFilterFactory getInstance() {
		//TODO : YOU MUST IMPLEMENT THIS METHOD
		//TODO : Check if this singleton implementation is correct
		return tff;
	}
	
	/**
	 * Returns a fully constructed {@link TokenFilter} instance
	 * for a given {@link TokenFilterType} type
	 * @param type: The {@link TokenFilterType} for which the {@link TokenFilter}
	 * is requested
	 * @param stream: The TokenStream instance to be wrapped
	 * @return The built {@link TokenFilter} instance
	 */
	public TokenFilter getFilterByType(TokenFilterType type, TokenStream stream) {
		//TODO : YOU MUST IMPLEMENT THIS METHOD
		TokenFilter out = null;
		
		switch (type) {
		case SYMBOL:
			out = new SymbolsTokenFilter(stream);
			break;
		case DATE:
			out = new DateTokenFilter(stream);
                        break;
		case NUMERIC:
			out = new NumericTokenFilter(stream);
                        break;
		case CAPITALIZATION:
                        out = new CapitalizationTokenFilter(stream);
			break;
		case STOPWORD:
			out = new StopwordTokenFilter(stream);
                        break;
		case STEMMER:
			out = new StemmerTokenFilter(stream);
                        break;
		case ACCENT:
			out = new AccentsTokenFilter(stream);
                        break;
		case SPECIALCHARS:
			out = new SpecialCharsTokenFilter(stream);
			break;		
		//Similarly for other TokenFilterTypes
		}
		
		return out;
	}
}
