import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.PeriodType;

public class Main {

	public static <T> void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2016, 6, 20);
		formatarIdadeAnosMeses(c);
		/*BigDecimal [] desfribilacao = new BigDecimal [3];
		desfribilacao[0] = new BigDecimal(10);
		desfribilacao[1] = new BigDecimal(11);
		
		List<Object []> lista = new ArrayList<Object []>();
		lista.add(new String[]{"Andre", "Lucas", "Vectra"});
		lista.add(new String[]{"Cesar", "João", "Corsa"});
		lista.add(new String[]{"Juca", "Carlos", "Cruze"});
		lista.add(new String[]{"Florentina", "Faker", "Cerato"});
		
		ProjectionHelper ph = new ProjectionHelper();
		try {
			List<Pessoa> list = ph.transformList(Pessoa.class, lista,  new String[]{"name", "filho.name", "filho.carro.name"});
		} catch (ProjectionHelperException e) {
			e.printStackTrace();
		}*/
	}
	
	public static String formatarIdadeAnosMeses(Calendar data){
		
		Interval intervalo = new Interval(new DateTime(data), new DateTime());
		org.joda.time.Period period = intervalo.toPeriod(PeriodType.yearMonthDay());
		
		Integer vAnos = period.getYears();
		Integer vMeses = period.getMonths();
		Integer vWeeks = period.getWeeks();
		Integer vDias = period.getDays();
		StringBuffer retorno = new StringBuffer(20);

		if(vAnos > 1){
			retorno.append(vAnos).append(" anos ");
		}else if(vAnos == 1){
			retorno.append(vAnos).append(" ano ");
		}
		if(vMeses > 1){
			retorno.append(vMeses).append(" meses ");
		}else if(vMeses == 1){
			retorno.append(vMeses).append(" mês ");
		}
		if(vAnos == 0 && vMeses == 0){
			if(vDias > 1){
				retorno.append(vDias).append(" dias ");
			}else if(vDias == 1){
				retorno.append(vDias).append(" dia ");
			}
		}
		
		return retorno.toString();
	}

}
