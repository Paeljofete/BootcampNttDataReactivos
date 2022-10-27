package taller1.psp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import taller1.psp.Product.Tax;

public class MainFun {
	public static void main(String[] args) {
		List<Product> shopping = List.of(new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
				new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
				new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
				new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
				new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
				new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));

		BigDecimal sum = shopping.stream()
				.map(x -> x.price.add(x.price.multiply(new BigDecimal(x.tax.percent)).divide(new BigDecimal(100))))
				.reduce(BigDecimal.ZERO, (x, y) -> x.add(y)).setScale(2, RoundingMode.CEILING);

		System.out.println("Compra total con impuestos: " + sum);

		String c = shopping.stream()
				.filter(x -> x.name.startsWith("C"))
				.sorted((x, y) -> x.name.compareToIgnoreCase(y.name))
				.map(x -> x.name)
				.collect(Collectors.joining(", "));

		System.out.println("Lista ordenadas por C: " + c);

	}

}
