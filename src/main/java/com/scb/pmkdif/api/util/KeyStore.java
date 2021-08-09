/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scb.pmkdif.api.util;

/**
 *
 * @author popsr
 */
class KeyStore {

    private static String secretKey = "dxL\\d).Ac{.%S4p-v$Ec~]UM2~2`U.qJ2~S4uk`-<QD,H_z-2LemCb\\R27U7TK#M{w)N\\{v8;9M(Sm'DTk{].799uZ`m2.;6qkCY::Z.bt7}<P-6=#$%2HVs:CUE.._t";
    private static String salt = "S9:c_)2B]:D4,U99\\6\"xGC)@7jKP>NQs,;e\\D34SDSF8Fp#./GP{E9uJZMm}{r\"#\\.a<>*{678_'\"xR2*#4.5JX[X8'5KmsP[kBD{*6[mj,K;g3=g\\%Cv5WQ>GX<?=8/";

    /**
     * @return the secretKey
     */
    protected static String getSecretKey() {
        return secretKey;
    }

   

    /**
     * @return the salt
     */
    protected static String getSalt() {
        return salt;
    }


}
