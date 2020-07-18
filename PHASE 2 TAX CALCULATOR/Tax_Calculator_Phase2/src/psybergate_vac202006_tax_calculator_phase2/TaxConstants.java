package psybergate_vac202006_tax_calculator_phase2;

public class TaxConstants {
	public static final double TAX_RATE1 = 0.18;
	public static final double TAX_RATE2 = 0.26;
	public static final double TAX_RATE3 = 0.31;
	public static final double TAX_RATE4 = 0.36;
	public static final double TAX_RATE5 = 0.39;
	public static final double TAX_RATE6 = 0.41;
	public static final double TAX_RATE7 = 0.45;

	public static final double TAX_DIFF1 = 205900;
	public static final double TAX_DIFF2 = 115699;
    public static final double TAX_DIFF3 = 123499;
    public static final double TAX_DIFF4 = 139099;
    public static final double TAX_DIFF5 = 160599;
    public static final double TAX_DIFF6 = 832499;
    //public static final double TAX_DIFF7 = 998422699;

	public static final double CAPITAL_GAIN_EXEMPTION = 40000;
	public static final double CAPITAL_GAIN_RATE = 0.4;
	public static final double INTEREST_EXEMPTION = 23500;
	public static final double RETIRE_FUND_RATE = 0.275;
	public static final double TRAVEL_ALLOW_EXEMPTION = 80000;
	public static final double PRIMARY_REBATE = 14958;
	
	public static final String url = "jdbc:postgresql://localhost:5432/Tax_Calculator_Phase2";
	public static final String user = "postgres";
	public static final String password = "1234";
}
