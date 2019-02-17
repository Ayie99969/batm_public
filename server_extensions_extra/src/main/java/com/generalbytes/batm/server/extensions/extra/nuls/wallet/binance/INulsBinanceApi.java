/*
 *
 * Copyright (C) 2014-2018 GENERAL BYTES s.r.o. All rights reserved.
 *
 * This software may be distributed and modified under the terms of the GNU
 * General Public License version 2 (GPL2) as published by the Free Software
 * Foundation and appearing in the file GPL2.TXT included in the packaging of
 * this file. Please note that GPL2 Section 2[b] requires that all works based
 * on this software must also be made publicly available under the terms of
 * the GPL2 ("Copyleft").
 *
 * Contact information
 * -------------------
 *
 * GENERAL BYTES s.r.o.
 * Web      :  http://www.generalbytes.com
 *
*/
package com.generalbytes.batm.server.extensions.extra.nuls.wallet.binance;

import com.generalbytes.batm.server.extensions.extra.lisk.wallets.liskbinancewallet.LskBinanceResponse;
import com.generalbytes.batm.server.extensions.extra.lisk.wallets.liskbinancewallet.LskSendCoinResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * @author naveen
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface INulsBinanceApi {

    /**
     * Get balance of given Binance account
     * @param apiKey Binance api key
     * @param recvWindow
     * @param timeStamp
     * @param signature
     * @return
     * @throws IOException
     */
    @GET
    @Path("/api/v3/account")
    NulsBinanceResponse getCryptoBalance(@HeaderParam("X-MBX-APIKEY") String apiKey, @QueryParam("recvWindow") String recvWindow, @QueryParam("timestamp") String timeStamp, @QueryParam("signature") String signature) throws IOException;

    /**
     * Withdraw funds from Binance account
     * @param apiKey
     * @param asset
     * @param address
     * @param amount
     * @param name
     * @param recvWindow
     * @param timeStamp
     * @param signature
     * @return
     * @throws IOException
     */
    @POST
    @Path("wapi/v1/withdraw.html")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    NulsSendCoinResponse sendNuls(@HeaderParam("X-MBX-APIKEY") String apiKey, @QueryParam("asset") String asset, @QueryParam("address") String address, @QueryParam("amount") String amount, @QueryParam("name") String name, @QueryParam("recvWindow") String recvWindow, @QueryParam("timestamp") String timeStamp, @QueryParam("signature") String signature) throws IOException;
}
