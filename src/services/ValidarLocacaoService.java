package services;

import exeception.DataException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ValidarLocacaoService {

    public static long validarDataDaLocacao(Date dataLocacao, Date dataDevolucao) {
        long dataValida = dataDevolucao.getTime() - dataLocacao.getTime();
        return TimeUnit.DAYS.convert(dataValida, TimeUnit.DAYS);
    }

    public static void validarDatas(Date dataLocacao, Date dataDevolucao) throws DataException {
        if (!dataDevolucao.after(dataLocacao)) {
            throw new DataException("Data inválida ");
        }
    }
}
