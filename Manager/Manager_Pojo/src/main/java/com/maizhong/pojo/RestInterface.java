package com.maizhong.pojo;

public class RestInterface {
    private Long id;

    private String interfaceName;

    private String interfaceUrl;

    private String interfaceParam;

    private String interfaceDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl == null ? null : interfaceUrl.trim();
    }

    public String getInterfaceParam() {
        return interfaceParam;
    }

    public void setInterfaceParam(String interfaceParam) {
        this.interfaceParam = interfaceParam == null ? null : interfaceParam.trim();
    }

    public String getInterfaceDesc() {
        return interfaceDesc;
    }

    public void setInterfaceDesc(String interfaceDesc) {
        this.interfaceDesc = interfaceDesc == null ? null : interfaceDesc.trim();
    }
}