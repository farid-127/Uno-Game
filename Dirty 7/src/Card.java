import java.util.Objects;

/**
 * Cards Class.
 */
public class Card {
    private String color;
    private String number;
    /**
     * The White.
     */
    protected final String white = "W";
    /**
     * The Blue.
     */
    protected final String blue = "B";
    /**
     * The Red.
     */
    protected final String red = "R";
    /**
     * The Green.
     */
    protected final String green = "G";

    /**
     * Instantiates a new Card.
     *
     * @param color  the color
     * @param number the number
     */
    public Card(String color, String number)
    {
        this.color = color;
        this.number = number;
    }

    /**
     * creates the cards (52 cards).
     */
    public void creatCards()
    {
        for (int i = 0; i < 13; i++) {
            int j = i + 2;
            if (j > 10)
            {
                j -= 11;
                char ch = (char) ((int) 'A' + j);
                String st = "";
                st += ch;
                if (st.equals("A") || st.equals("B"))
                {
                    Config.cards.add(new SpecialCard(white,st));
                    Config.cards.add(new SpecialCard(blue,st));
                    Config.cards.add(new SpecialCard(red,st));
                    Config.cards.add(new SpecialCard(green,st));
                    continue;
                }
                Config.cards.add(new NormalCard(white,st));
                Config.cards.add(new NormalCard(blue,st));
                Config.cards.add(new NormalCard(red,st));
                Config.cards.add(new NormalCard(green,st));
                continue;
            }
            /* 2 7 8 10 */
            if (j == 2 || j == 7 || j == 8 || j == 10)
            {
                Config.cards.add(new SpecialCard(white,Integer.toString(j)));
                Config.cards.add(new SpecialCard(blue,Integer.toString(j)));
                Config.cards.add(new SpecialCard(red,Integer.toString(j)));
                Config.cards.add(new SpecialCard(green,Integer.toString(j)));
                continue;
            }
            Config.cards.add(new NormalCard(white,Integer.toString(j)));
            Config.cards.add(new NormalCard(blue,Integer.toString(j)));
            Config.cards.add(new NormalCard(red,Integer.toString(j)));
            Config.cards.add(new NormalCard(green,Integer.toString(j)));
        }
    }

    /**
     * Display card.
     */
    public void displayCard() {
        String color = Config.displayColor(this.color);
        int j = 0;
        System.out.print(color + "┌");
        for (int i = 0; i < 10; i++)
            System.out.print("─");
        System.out.println("┐");
        for (int i = 0; i < 4; i++) {
            if (j == 0) {
                System.out.print("│  " + this.number + "    " + this.color +  "  │");
                if (this.number.equals("10"))
                    System.out.print("\b\b│");
                System.out.println();
                j++;
            }
            else if (i == 3) {
                System.out.print("│  " + this.color +"    " + this.number +  "  │");
                if (this.number.equals("10"))
                    System.out.print("\b\b│");
                System.out.println();
            }
            else
                System.out.println("│          │");
        }
        System.out.print("└");
        for (int i = 0; i < 10; i++)
            System.out.print("─");
        System.out.println("┘");
        System.out.println(Config.displayColor("reset"));
    }

    /**
     * check that the card is special or not.
     *
     * @return true if card is special.
     */
    public boolean isSpecial()
    {
        if (this instanceof SpecialCard)
        {
            return true;
        }
        else
            return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(color, card.color) && Objects.equals(number, card.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, number);
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }
}
