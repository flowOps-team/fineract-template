/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.portfolio.loanaccount.domain;

public enum LoanTransactionType {

    INVALID(0, "loanTransactionType.invalid"), //
    DISBURSEMENT(1, "loanTransactionType.disbursement"), //
    REPAYMENT(2, "loanTransactionType.repayment"), //
    CONTRA(3, "loanTransactionType.contra"), //
    WAIVE_INTEREST(4, "loanTransactionType.waiver"), //
    REPAYMENT_AT_DISBURSEMENT(5, "loanTransactionType.repaymentAtDisbursement"), //
    WRITEOFF(6, "loanTransactionType.writeOff"), //
    MARKED_FOR_RESCHEDULING(7, "loanTransactionType.marked.for.rescheduling"), //
    TOP_UP(25, "loanTransactionType.topUp"),
    /**
     * This type of transactions is allowed on written-off loans where mfi still attempts to recover payments from
     * applicant after writing-off.
     */
    RECOVERY_REPAYMENT(8, "loanTransactionType.recoveryRepayment"), //
    WAIVE_CHARGES(9, "loanTransactionType.waiveCharges"), //
    // UNDO_WAIVE_CHARGE(20, "loanTransactionType.undoWaiveCharge"),
    /**
     * Transaction represents an Accrual (For either interest, charge or a penalty
     **/
    ACCRUAL(10, "loanTransactionType.accrual"), //

    /***
     * A Loan Transfer involves two steps, first a "initiate" Loan transfer transaction done by the Source branch
     * followed by a "complete" loan transaction initiated by the destination branch
     **/
    INITIATE_TRANSFER(12, "loanTransactionType.initiateTransfer"), //
    APPROVE_TRANSFER(13, "loanTransactionType.approveTransfer"), //
    WITHDRAW_TRANSFER(14, "loanTransactionType.withdrawTransfer"), //
    REJECT_TRANSFER(15, "loanTransactionType.rejectTransfer"), //
    REFUND(16, "loanTransactionType.refund"), //
    CHARGE_PAYMENT(17, "loanTransactionType.chargePayment"), //
    REFUND_FOR_ACTIVE_LOAN(18, "loanTransactionType.refund"), //
    INCOME_POSTING(19, "loanTransactionType.incomePosting"), //
    CREDIT_BALANCE_REFUND(20, "loanTransactionType.creditBalanceRefund"), //
    MERCHANT_ISSUED_REFUND(21, "loanTransactionType.merchantIssuedRefund"), //
    PAYOUT_REFUND(22, "loanTransactionType.payoutRefund"), //
    GOODWILL_CREDIT(23, "loanTransactionType.goodwillCredit"), //
    BNPL_VENDOR_TRANSFER(24, "loanTransactionType.bnplVendorTransfer");

    private final Integer value;
    private final String code;

    LoanTransactionType(final Integer value, final String code) {
        this.value = value;
        this.code = code;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public static LoanTransactionType fromInt(final Integer transactionType) {

        if (transactionType == null) {
            return LoanTransactionType.INVALID;
        }

        LoanTransactionType loanTransactionType = null;
        switch (transactionType) {
            case 1:
                loanTransactionType = LoanTransactionType.DISBURSEMENT;
            break;
            case 2:
                loanTransactionType = LoanTransactionType.REPAYMENT;
            break;
            case 3:
                loanTransactionType = LoanTransactionType.CONTRA;
            break;
            case 4:
                loanTransactionType = LoanTransactionType.WAIVE_INTEREST;
            break;
            case 5:
                loanTransactionType = LoanTransactionType.REPAYMENT_AT_DISBURSEMENT;
            break;
            case 6:
                loanTransactionType = LoanTransactionType.WRITEOFF;
            break;
            case 7:
                loanTransactionType = LoanTransactionType.MARKED_FOR_RESCHEDULING;
            break;
            case 8:
                loanTransactionType = LoanTransactionType.RECOVERY_REPAYMENT;
            break;
            case 9:
                loanTransactionType = LoanTransactionType.WAIVE_CHARGES;
            break;
            case 10:
                loanTransactionType = LoanTransactionType.ACCRUAL;
            break;
            case 12:
                loanTransactionType = LoanTransactionType.INITIATE_TRANSFER;
            break;
            case 13:
                loanTransactionType = LoanTransactionType.APPROVE_TRANSFER;
            break;
            case 14:
                loanTransactionType = LoanTransactionType.WITHDRAW_TRANSFER;
            break;
            case 15:
                loanTransactionType = LoanTransactionType.REJECT_TRANSFER;
            break;
            case 16:
                loanTransactionType = LoanTransactionType.REFUND;
            break;
            case 17:
                loanTransactionType = LoanTransactionType.CHARGE_PAYMENT;
            break;
            case 18:
                loanTransactionType = LoanTransactionType.REFUND_FOR_ACTIVE_LOAN;
            break;
            case 19:
                loanTransactionType = LoanTransactionType.INCOME_POSTING;
            break;
            case 20:
                loanTransactionType = LoanTransactionType.CREDIT_BALANCE_REFUND;
            break;
            case 21:
                loanTransactionType = LoanTransactionType.MERCHANT_ISSUED_REFUND;
            break;
            case 22:
                loanTransactionType = LoanTransactionType.PAYOUT_REFUND;
            break;
            case 23:
                loanTransactionType = LoanTransactionType.GOODWILL_CREDIT;
            break;
            case 24:
                loanTransactionType = LoanTransactionType.BNPL_VENDOR_TRANSFER;
            break;
            case 25:
                loanTransactionType = LoanTransactionType.TOP_UP;
            break;
            default:
                loanTransactionType = LoanTransactionType.INVALID;
            break;
        }
        return loanTransactionType;
    }

    public boolean isDisbursement() {
        return this.value.equals(LoanTransactionType.DISBURSEMENT.getValue());
    }

    public boolean isRepaymentAtDisbursement() {
        return this.value.equals(LoanTransactionType.REPAYMENT_AT_DISBURSEMENT.getValue());
    }

    public boolean isRepayment() {
        return this.value.equals(LoanTransactionType.REPAYMENT.getValue());
    }

    public boolean isMerchantIssuedRefund() {
        return this.value.equals(LoanTransactionType.MERCHANT_ISSUED_REFUND.getValue());
    }

    public boolean isPayoutRefund() {
        return this.value.equals(LoanTransactionType.PAYOUT_REFUND.getValue());
    }

    public boolean isGoodwillCredit() {
        return this.value.equals(LoanTransactionType.GOODWILL_CREDIT.getValue());
    }

    public boolean isRepaymentType() {
        return (isRepayment() || isMerchantIssuedRefund() || isPayoutRefund() || isGoodwillCredit());
    }

    public boolean isRecoveryRepayment() {
        return this.value.equals(LoanTransactionType.RECOVERY_REPAYMENT.getValue());
    }

    public boolean isWaiveInterest() {
        return this.value.equals(LoanTransactionType.WAIVE_INTEREST.getValue());
    }

    public boolean isWaiveCharges() {
        return this.value.equals(LoanTransactionType.WAIVE_CHARGES.getValue());
    }

    public boolean isAccrual() {
        return this.value.equals(LoanTransactionType.ACCRUAL.getValue());
    }

    public boolean isWriteOff() {
        return this.value.equals(LoanTransactionType.WRITEOFF.getValue());
    }

    public boolean isChargePayment() {
        return this.value.equals(LoanTransactionType.CHARGE_PAYMENT.getValue());
    }

    public boolean isRefundForActiveLoan() {
        return this.value.equals(LoanTransactionType.REFUND_FOR_ACTIVE_LOAN.getValue());
    }

    public boolean isIncomePosting() {
        return this.value.equals(LoanTransactionType.INCOME_POSTING.getValue());
    }
}
