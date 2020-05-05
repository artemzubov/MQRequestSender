package com.trgr.dockets.RequestSender.domain;

public class MqRequestDto {

    private String sourceFile;
    private Long courtId;
    private String workflowType;
    private String requestInitiatorType;
    private Long productId;
    private boolean fifoOverride;
    private boolean aqTimeOverride;
    private Long vendorId;
    private String requestType;
    private String requestName;

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public String getWorkflowType() {
        return workflowType;
    }

    public void setWorkflowType(String workflowType) {
        this.workflowType = workflowType;
    }

    public String getRequestInitiatorType() {
        return requestInitiatorType;
    }

    public void setRequestInitiatorType(String requestInitiatorType) {
        this.requestInitiatorType = requestInitiatorType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public boolean isFifoOverride() {
        return fifoOverride;
    }

    public void setFifoOverride(boolean fifoOverride) {
        this.fifoOverride = fifoOverride;
    }

    public boolean isAqTimeOverride() {
        return aqTimeOverride;
    }

    public void setAqTimeOverride(boolean aqTimeOverride) {
        this.aqTimeOverride = aqTimeOverride;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }
}
