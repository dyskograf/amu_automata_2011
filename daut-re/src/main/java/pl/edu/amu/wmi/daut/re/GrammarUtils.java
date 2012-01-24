package pl.edu.amu.wmi.daut.re;

import java.util.List;

/**
 * @author dyskograf Klasa przechowująca narzędzia do obsługi gramatyk..
 */
public class GrammarUtils {

    /**
     * Metoda sprawdzająca, czy podana gramatyka jest w postaci normalnej
     * Chomsky'ego.
     */
    public boolean isChomsky(Grammar g) {

        List<GrammarRule> rules = g.allRules();

        for (GrammarRule rule : rules) {
            if (rule.getArity() > 2
                    || rule.getArity() == 0
                    || ((rule.getRhsSecondSymbol().isTerminalSymbol())
                            && (rule.getArity() == 2))
                    || (!(rule.getRhsFirstSymbol().isTerminalSymbol())
                            && (rule.getArity() == 1))
                    || (rule.getRhsFirstSymbol().isTerminalSymbol()
                            && !(rule.getRhsSecondSymbol().isTerminalSymbol())
                            && rule.getArity() == 2)) {
                return false;
            }
        }
        return true;
    }
}
