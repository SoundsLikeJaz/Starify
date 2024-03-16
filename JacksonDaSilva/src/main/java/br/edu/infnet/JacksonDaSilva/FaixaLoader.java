package br.edu.infnet.JacksonDaSilva;

import br.edu.infnet.JacksonDaSilva.model.domain.Faixa;
import br.edu.infnet.JacksonDaSilva.model.service.FaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class FaixaLoader implements ApplicationRunner {
    @Autowired
    private FaixaService faixaService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Faixa brandNewCity = faixaService.obter("47k7FCxk7ylTwKCnJ3QTVc");
        System.out.println(brandNewCity);
        faixaService.incluir(brandNewCity);

        Faixa villain = faixaService.obter("3QSjVPObHxuAJc3E5nrjRn");
        System.out.println(villain);
        faixaService.incluir(villain);

        Faixa lightbringer = faixaService.obter("7ixYgkcd8aptv5bBAmQXYF");
        System.out.println(lightbringer);
        faixaService.incluir(lightbringer);

        Faixa americaHasAProblem = faixaService.obter("6l8mgVN9Xf1hiDIFGA6CTE");
        System.out.println(americaHasAProblem);
        faixaService.incluir(americaHasAProblem);
    }
}