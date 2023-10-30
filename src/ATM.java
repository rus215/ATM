import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ATM {
    private final Map<Integer, Integer> banknotes;
    private final int minimalBanknote;

    public ATM(Map<Integer, Integer> banknotes) {
        this.banknotes = banknotes;
        this.minimalBanknote = getLastElement(banknotes);
    }

    public Map<Integer, Integer> getCashe(int sum) {
        validateSum(sum);
        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (Integer banknote : banknotes.keySet()) {
            if (sum == 0) {
                break;
            }
            int neededCount = sum / banknote;
            if (neededCount > 0) {
                Integer currentCount = banknotes.get(banknote);
                if (currentCount >= neededCount) {
                    result.put(banknote, neededCount);
                    sum -= neededCount * banknote;
                    banknotes.put(banknote, currentCount - neededCount);
                }
            }
        }
        if (sum != 0) {
            throw new RuntimeException("Сумма не может быть выдана, в банкомате не достаточно денег");
        }
        return result;
    }

    public Map<Integer, Integer> getBanknotes() {
        return banknotes;
    }

    private void validateSum(int sum) {
        if (sum % 2 == 1) {
            throw new RuntimeException("Сумма должна быть чётным числом");
        } else if (sum <= 0) {
            throw new RuntimeException("Сумма должна быть положительным числом");
        } else if (sum < minimalBanknote) {
            throw new RuntimeException(String.format("Минимально допустимая сумма: %d", minimalBanknote));
        }
    }

    private static int getLastElement(Map<Integer, Integer> banknotes) {
        Iterator<Integer> iterator = banknotes.keySet().iterator();
        int last = 0;
        while (iterator.hasNext()) {
            last = iterator.next();
        }
        return last;
    }
}
