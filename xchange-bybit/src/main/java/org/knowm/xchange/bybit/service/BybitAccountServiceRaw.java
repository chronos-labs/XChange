package org.knowm.xchange.bybit.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.bybit.BybitAdapters;
import org.knowm.xchange.bybit.dto.BybitResult;
import org.knowm.xchange.bybit.dto.account.BybitBalances;

import java.io.IOException;

import static org.knowm.xchange.bybit.BybitAdapters.createBybitExceptionFromResult;

public class BybitAccountServiceRaw extends BybitBaseService {

  public BybitAccountServiceRaw(Exchange exchange) {
    super(exchange);
  }

  public BybitResult<BybitBalances> getWalletBalances() throws IOException {
    BybitResult<BybitBalances> walletBalances = bybitAuthenticated.getWalletBalances(apiKey, nonceFactory, signatureCreator);
    if (!walletBalances.isSuccess()) {
      throw createBybitExceptionFromResult(walletBalances);
    }
    return walletBalances;
  }

}