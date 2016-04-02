/**
 * HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.java
 * <p/>
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
package soap;


/*
 *  HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub java implementation
 */
public class HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub extends org.apache.axis2.client.Stub {
    private static int counter = 0;
    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();
    private javax.xml.namespace.QName[] opNameArray = null;

    /**
     *Constructor that takes in a configContext
     */
    public HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub(
            org.apache.axis2.context.ConfigurationContext configurationContext,
            java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub(
            org.apache.axis2.context.ConfigurationContext configurationContext,
            java.lang.String targetEndpoint, boolean useSeparateListener)
            throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,
                _service);

        _serviceClient.getOptions()
                .setTo(new org.apache.axis2.addressing.EndpointReference(
                        targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
    }

    /**
     * Default Constructor
     */
    public HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub(
            org.apache.axis2.context.ConfigurationContext configurationContext)
            throws org.apache.axis2.AxisFault {
        this(configurationContext,
                "http://120.24.68.64:7778/eai_chs/start.swe?SWEExtSource=WebService&SWEExtCmd=Execute&Username=SADMIN&Password=SADMIN");
    }

    /**
     * Default Constructor
     */
    public HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub()
            throws org.apache.axis2.AxisFault {
        this(
                "http://120.24.68.64:7778/eai_chs/start.swe?SWEExtSource=WebService&SWEExtCmd=Execute&Username=SADMIN&Password=SADMIN");
    }

    /**
     * Constructor taking the target endpoint
     */
    public HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub(
            java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    private static synchronized java.lang.String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }

        counter = counter + 1;

        return java.lang.Long.toString(java.lang.System.currentTimeMillis()) +
                "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {
        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService(
                "HUHU_spcCreate_spcOrder_spcWeb_spcService" +
                        getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[1];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://siebel.com/CustomUI", "createdOrder"));
        _service.addOperation(__operation);

        _operations[0] = __operation;
    }

    //populates the faults
    private void populateFaults() {
    }

    /**
     * Auto generated method signature
     *
     * @see soap.HUHU_spcCreate_spcOrder_spcWeb_spcService#createdOrder
     * @param createdOrder_Input
     */
    public soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output createdOrder(
            soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Input createdOrder_Input)
            throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions()
                    .setAction("document/http://siebel.com/CustomUI:createdOrder");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    createdOrder_Input,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "createdOrder")),
                    new javax.xml.namespace.QName(
                            "http://siebel.com/CustomUI", "createdOrder_Input"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output.class);

            return (soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "createdOrder"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "createdOrder"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(java.lang.String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());

                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "createdOrder"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,
                                messageClass);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        if (opNameArray == null) {
            return false;
        }

        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }

        return false;
    }

    private org.apache.axiom.om.OMElement toOM(
            soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Input param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Input.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Input param,
            boolean optimizeContent, javax.xml.namespace.QName elementQName)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                    .addChild(param.getOMElement(
                            soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Input.MY_QNAME,
                            factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
                                    java.lang.Class type) throws org.apache.axis2.AxisFault {
        try {
            if (soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Input.class.equals(
                    type)) {
                return soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Input.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output.class.equals(
                    type)) {
                return soap.HUHU_spcCreate_spcOrder_spcWeb_spcServiceStub.CreatedOrder_Output.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    //http://120.24.68.64:7778/eai_chs/start.swe?SWEExtSource=WebService&SWEExtCmd=Execute&Username=SADMIN&Password=SADMIN
    public static class OrderEntryLineItems implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = orderEntry-LineItems
           Namespace URI = http://www.siebel.com/xml/HUHU%20Order%20Line%20Message
           Namespace Prefix = ns1
         */

        /**
         * field for Itemid
         */
        protected java.lang.String localItemid = "";

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localItemidTracker = false;

        /**
         * field for Itemdesc
         */
        protected java.lang.String localItemdesc = "";

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localItemdescTracker = false;

        /**
         * field for Deliverydate
         */
        protected java.lang.String localDeliverydate;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localDeliverydateTracker = false;

        /**
         * field for Prodid
         */
        protected java.lang.String localProdid;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localProdidTracker = false;

        /**
         * field for Producttype
         * 产品\促销
         */
        protected java.lang.String localProducttype;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localProducttypeTracker = false;

        /**
         * field for Reverse1
         */
        protected java.lang.String localReverse1 = "";

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localReverse1Tracker = false;

        /**
         * field for Reverse2
         */
        protected java.lang.String localReverse2 = "";

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localReverse2Tracker = false;

        /**
         * field for Reverse3
         */
        protected java.lang.String localReverse3 = "";

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localReverse3Tracker = false;

        /**
         * field for Reverse4
         */
        protected java.lang.String localReverse4 = "";

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localReverse4Tracker = false;

        /**
         * field for Reverse5
         */
        protected java.lang.String localReverse5 = "";

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localReverse5Tracker = false;

        private static java.lang.String generatePrefix(
                java.lang.String namespace) {
            if (namespace.equals(
                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        public boolean isItemidSpecified() {
            return localItemidTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getItemid() {
            return localItemid;
        }

        /**
         * Auto generated setter method
         * @param param Itemid
         */
        public void setItemid(java.lang.String param) {
            localItemidTracker = param != null;

            this.localItemid = param;
        }

        public boolean isItemdescSpecified() {
            return localItemdescTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getItemdesc() {
            return localItemdesc;
        }

        /**
         * Auto generated setter method
         * @param param Itemdesc
         */
        public void setItemdesc(java.lang.String param) {
            localItemdescTracker = param != null;

            this.localItemdesc = param;
        }

        public boolean isDeliverydateSpecified() {
            return localDeliverydateTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getDeliverydate() {
            return localDeliverydate;
        }

        /**
         * Auto generated setter method
         * @param param Deliverydate
         */
        public void setDeliverydate(java.lang.String param) {
            localDeliverydateTracker = param != null;

            this.localDeliverydate = param;
        }

        public boolean isProdidSpecified() {
            return localProdidTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getProdid() {
            return localProdid;
        }

        /**
         * Auto generated setter method
         * @param param Prodid
         */
        public void setProdid(java.lang.String param) {
            localProdidTracker = param != null;

            this.localProdid = param;
        }

        public boolean isProducttypeSpecified() {
            return localProducttypeTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getProducttype() {
            return localProducttype;
        }

        /**
         * Auto generated setter method
         * @param param Producttype
         */
        public void setProducttype(java.lang.String param) {
            localProducttypeTracker = param != null;

            this.localProducttype = param;
        }

        public boolean isReverse1Specified() {
            return localReverse1Tracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReverse1() {
            return localReverse1;
        }

        /**
         * Auto generated setter method
         * @param param Reverse1
         */
        public void setReverse1(java.lang.String param) {
            localReverse1Tracker = param != null;

            this.localReverse1 = param;
        }

        public boolean isReverse2Specified() {
            return localReverse2Tracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReverse2() {
            return localReverse2;
        }

        /**
         * Auto generated setter method
         * @param param Reverse2
         */
        public void setReverse2(java.lang.String param) {
            localReverse2Tracker = param != null;

            this.localReverse2 = param;
        }

        public boolean isReverse3Specified() {
            return localReverse3Tracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReverse3() {
            return localReverse3;
        }

        /**
         * Auto generated setter method
         * @param param Reverse3
         */
        public void setReverse3(java.lang.String param) {
            localReverse3Tracker = param != null;

            this.localReverse3 = param;
        }

        public boolean isReverse4Specified() {
            return localReverse4Tracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReverse4() {
            return localReverse4;
        }

        /**
         * Auto generated setter method
         * @param param Reverse4
         */
        public void setReverse4(java.lang.String param) {
            localReverse4Tracker = param != null;

            this.localReverse4 = param;
        }

        public boolean isReverse5Specified() {
            return localReverse5Tracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReverse5() {
            return localReverse5;
        }

        /**
         * Auto generated setter method
         * @param param Reverse5
         */
        public void setReverse5(java.lang.String param) {
            localReverse5Tracker = param != null;

            this.localReverse5 = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                    xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":orderEntry-LineItems", xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "orderEntry-LineItems", xmlWriter);
                }
            }

            if (localItemidTracker) {
                namespace = "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message";
                writeStartElement(null, namespace, "itemid", xmlWriter);

                if (localItemid == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                            "itemid cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localItemid);
                }

                xmlWriter.writeEndElement();
            }

            if (localItemdescTracker) {
                namespace = "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message";
                writeStartElement(null, namespace, "itemdesc", xmlWriter);

                if (localItemdesc == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                            "itemdesc cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localItemdesc);
                }

                xmlWriter.writeEndElement();
            }

            if (localDeliverydateTracker) {
                namespace = "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message";
                writeStartElement(null, namespace, "deliverydate", xmlWriter);

                if (localDeliverydate == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                            "deliverydate cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localDeliverydate);
                }

                xmlWriter.writeEndElement();
            }

            if (localProdidTracker) {
                namespace = "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message";
                writeStartElement(null, namespace, "prodid", xmlWriter);

                if (localProdid == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                            "prodid cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localProdid);
                }

                xmlWriter.writeEndElement();
            }

            if (localProducttypeTracker) {
                namespace = "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message";
                writeStartElement(null, namespace, "producttype", xmlWriter);

                if (localProducttype == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                            "producttype cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localProducttype);
                }

                xmlWriter.writeEndElement();
            }

            if (localReverse1Tracker) {
                namespace = "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message";
                writeStartElement(null, namespace, "reverse1", xmlWriter);

                if (localReverse1 == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                            "reverse1 cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localReverse1);
                }

                xmlWriter.writeEndElement();
            }

            if (localReverse2Tracker) {
                namespace = "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message";
                writeStartElement(null, namespace, "reverse2", xmlWriter);

                if (localReverse2 == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                            "reverse2 cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localReverse2);
                }

                xmlWriter.writeEndElement();
            }

            if (localReverse3Tracker) {
                namespace = "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message";
                writeStartElement(null, namespace, "reverse3", xmlWriter);

                if (localReverse3 == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                            "reverse3 cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localReverse3);
                }

                xmlWriter.writeEndElement();
            }

            if (localReverse4Tracker) {
                namespace = "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message";
                writeStartElement(null, namespace, "reverse4", xmlWriter);

                if (localReverse4 == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                            "reverse4 cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localReverse4);
                }

                xmlWriter.writeEndElement();
            }

            if (localReverse5Tracker) {
                namespace = "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message";
                writeStartElement(null, namespace, "reverse5", xmlWriter);

                if (localReverse5 == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                            "reverse5 cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localReverse5);
                }

                xmlWriter.writeEndElement();
            }

            xmlWriter.writeEndElement();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
                                       java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
                                    java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
                                    java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
                                         java.lang.String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                java.lang.String namespace)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static OrderEntryLineItems parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws java.lang.Exception {
                OrderEntryLineItems object = new OrderEntryLineItems();

                int event;
                javax.xml.namespace.QName currentQName = null;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                            if (!"orderEntry-LineItems".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                        .getNamespaceURI(nsPrefix);

                                return (OrderEntryLineItems) ExtensionMapper.getTypeObject(nsUri,
                                        type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "itemid").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "itemid").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "itemid" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setItemid(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "itemdesc").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "itemdesc").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "itemdesc" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setItemdesc(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "deliverydate").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "deliverydate").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "deliverydate" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setDeliverydate(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "prodid").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "prodid").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "prodid" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setProdid(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "producttype").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "producttype").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "producttype" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setProducttype(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "reverse1").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "reverse1").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "reverse1" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setReverse1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "reverse2").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "reverse2").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "reverse2" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setReverse2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "reverse3").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "reverse3").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "reverse3" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setReverse3(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "reverse4").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "reverse4").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "reverse4" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setReverse4(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "reverse5").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("", "reverse5").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "reverse5" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setReverse5(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ListOforderEntryLineItems implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = listOforderEntry-LineItems
           Namespace URI = http://www.siebel.com/xml/HUHU%20Order%20Line%20Message
           Namespace Prefix = ns1
         */

        /**
         * field for OrderEntryLineItems
         * This was an Array!
         */
        protected OrderEntryLineItems[] localOrderEntryLineItems;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localOrderEntryLineItemsTracker = false;

        private static java.lang.String generatePrefix(
                java.lang.String namespace) {
            if (namespace.equals(
                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        public boolean isOrderEntryLineItemsSpecified() {
            return localOrderEntryLineItemsTracker;
        }

        /**
         * Auto generated getter method
         * @return OrderEntryLineItems[]
         */
        public OrderEntryLineItems[] getOrderEntryLineItems() {
            return localOrderEntryLineItems;
        }

        /**
         * Auto generated setter method
         * @param param OrderEntryLineItems
         */
        public void setOrderEntryLineItems(OrderEntryLineItems[] param) {
            validateOrderEntryLineItems(param);

            localOrderEntryLineItemsTracker = param != null;

            this.localOrderEntryLineItems = param;
        }

        /**
         * validate the array for OrderEntryLineItems
         */
        protected void validateOrderEntryLineItems(OrderEntryLineItems[] param) {
        }

        /**
         * Auto generated add method for the array for convenience
         * @param param OrderEntryLineItems
         */
        public void addOrderEntryLineItems(OrderEntryLineItems param) {
            if (localOrderEntryLineItems == null) {
                localOrderEntryLineItems = new OrderEntryLineItems[]{};
            }

            //update the setting tracker
            localOrderEntryLineItemsTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localOrderEntryLineItems);
            list.add(param);
            this.localOrderEntryLineItems = (OrderEntryLineItems[]) list.toArray(new OrderEntryLineItems[list.size()]);
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                    xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":listOforderEntry-LineItems",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "listOforderEntry-LineItems", xmlWriter);
                }
            }

            if (localOrderEntryLineItemsTracker) {
                if (localOrderEntryLineItems != null) {
                    for (int i = 0; i < localOrderEntryLineItems.length; i++) {
                        if (localOrderEntryLineItems[i] != null) {
                            localOrderEntryLineItems[i].serialize(new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "orderEntry-LineItems"), xmlWriter);
                        } else {
                            // we don't have to do any thing since minOccures is zero
                        }
                    }
                } else {
                    throw new org.apache.axis2.databinding.ADBException(
                            "orderEntry-LineItems cannot be null!!");
                }
            }

            xmlWriter.writeEndElement();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
                                       java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
                                    java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
                                    java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
                                         java.lang.String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                java.lang.String namespace)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ListOforderEntryLineItems parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws java.lang.Exception {
                ListOforderEntryLineItems object = new ListOforderEntryLineItems();

                int event;
                javax.xml.namespace.QName currentQName = null;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                            if (!"listOforderEntry-LineItems".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                        .getNamespaceURI(nsPrefix);

                                return (ListOforderEntryLineItems) ExtensionMapper.getTypeObject(nsUri,
                                        type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "orderEntry-LineItems").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("",
                                    "orderEntry-LineItems").equals(reader.getName())) {
                        // Process the array and step past its final element's end.
                        list1.add(OrderEntryLineItems.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;

                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();

                            // Step out of this element
                            reader.next();

                            // Step to next element event.
                            while (!reader.isStartElement() &&
                                    !reader.isEndElement())
                                reader.next();

                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName(
                                        "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                        "orderEntry-LineItems").equals(
                                        reader.getName())) {
                                    list1.add(OrderEntryLineItems.Factory.parse(
                                            reader));
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }

                        // call the converter utility  to convert and set the array
                        object.setOrderEntryLineItems((OrderEntryLineItems[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                OrderEntryLineItems.class, list1));
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ListOfHuhuOrderLineMessageE implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                "listOfHuhuOrderLineMessage", "ns1");

        /**
         * field for ListOfHuhuOrderLineMessage
         */
        protected ListOfHuhuOrderLineMessage localListOfHuhuOrderLineMessage;

        private static java.lang.String generatePrefix(
                java.lang.String namespace) {
            if (namespace.equals(
                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Auto generated getter method
         * @return ListOfHuhuOrderLineMessage
         */
        public ListOfHuhuOrderLineMessage getListOfHuhuOrderLineMessage() {
            return localListOfHuhuOrderLineMessage;
        }

        /**
         * Auto generated setter method
         * @param param ListOfHuhuOrderLineMessage
         */
        public void setListOfHuhuOrderLineMessage(
                ListOfHuhuOrderLineMessage param) {
            this.localListOfHuhuOrderLineMessage = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            //We can safely assume an element has only one type associated with it
            if (localListOfHuhuOrderLineMessage == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "listOfHuhuOrderLineMessage cannot be null!");
            }

            localListOfHuhuOrderLineMessage.serialize(MY_QNAME, xmlWriter);
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
                                       java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
                                    java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
                                    java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
                                         java.lang.String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                java.lang.String namespace)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ListOfHuhuOrderLineMessageE parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws java.lang.Exception {
                ListOfHuhuOrderLineMessageE object = new ListOfHuhuOrderLineMessageE();

                int event;
                javax.xml.namespace.QName currentQName = null;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if ((reader.isStartElement() &&
                                    new javax.xml.namespace.QName(
                                            "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                            "listOfHuhuOrderLineMessage").equals(
                                            reader.getName())) ||
                                    new javax.xml.namespace.QName("",
                                            "listOfHuhuOrderLineMessage").equals(
                                            reader.getName())) {
                                object.setListOfHuhuOrderLineMessage(ListOfHuhuOrderLineMessage.Factory.parse(
                                        reader));
                            } // End of if for expected property start element

                            else {
                                // 3 - A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException(
                                        "Unexpected subelement " +
                                                reader.getName());
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ExtensionMapper {
        public static java.lang.Object getTypeObject(
                java.lang.String namespaceURI, java.lang.String typeName,
                javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            if ("http://www.siebel.com/xml/HUHU%20Order%20Line%20Message".equals(
                    namespaceURI) &&
                    "listOfHuhuOrderLineMessage".equals(typeName)) {
                return ListOfHuhuOrderLineMessage.Factory.parse(reader);
            }

            if ("http://www.siebel.com/xml/HUHU%20Order%20Line%20Message".equals(
                    namespaceURI) &&
                    "orderEntry-LineItems".equals(typeName)) {
                return OrderEntryLineItems.Factory.parse(reader);
            }

            if ("http://www.siebel.com/xml/HUHU%20Order%20Line%20Message".equals(
                    namespaceURI) &&
                    "listOfHuhuOrderLineMessageTopElmt".equals(typeName)) {
                return ListOfHuhuOrderLineMessageTopElmt.Factory.parse(reader);
            }

            if ("http://www.siebel.com/xml/HUHU%20Order%20Line%20Message".equals(
                    namespaceURI) &&
                    "listOforderEntry-LineItems".equals(typeName)) {
                return ListOforderEntryLineItems.Factory.parse(reader);
            }

            throw new org.apache.axis2.databinding.ADBException(
                    "Unsupported type " + namespaceURI + " " + typeName);
        }
    }

    public static class CreatedOrder_Output implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://siebel.com/CustomUI",
                "createdOrder_Output", "ns2");

        /**
         * field for Orderamt
         */
        protected java.lang.String localOrderamt;

        /**
         * field for Orderid
         */
        protected java.lang.String localOrderid;

        /**
         * field for Ordernum
         */
        protected java.lang.String localOrdernum;

        /**
         * field for ProcMsg
         */
        protected java.lang.String localProcMsg;

        /**
         * field for ProcStatus
         */
        protected java.lang.String localProcStatus;

        private static java.lang.String generatePrefix(
                java.lang.String namespace) {
            if (namespace.equals("http://siebel.com/CustomUI")) {
                return "ns2";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getOrderamt() {
            return localOrderamt;
        }

        /**
         * Auto generated setter method
         * @param param Orderamt
         */
        public void setOrderamt(java.lang.String param) {
            this.localOrderamt = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getOrderid() {
            return localOrderid;
        }

        /**
         * Auto generated setter method
         * @param param Orderid
         */
        public void setOrderid(java.lang.String param) {
            this.localOrderid = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getOrdernum() {
            return localOrdernum;
        }

        /**
         * Auto generated setter method
         * @param param Ordernum
         */
        public void setOrdernum(java.lang.String param) {
            this.localOrdernum = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getProcMsg() {
            return localProcMsg;
        }

        /**
         * Auto generated setter method
         * @param param ProcMsg
         */
        public void setProcMsg(java.lang.String param) {
            this.localProcMsg = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getProcStatus() {
            return localProcStatus;
        }

        /**
         * Auto generated setter method
         * @param param ProcStatus
         */
        public void setProcStatus(java.lang.String param) {
            this.localProcStatus = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                    xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://siebel.com/CustomUI");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":createdOrder_Output", xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "createdOrder_Output", xmlWriter);
                }
            }

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "orderamt", xmlWriter);

            if (localOrderamt == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "orderamt cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localOrderamt);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "orderid", xmlWriter);

            if (localOrderid == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "orderid cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localOrderid);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "ordernum", xmlWriter);

            if (localOrdernum == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "ordernum cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localOrdernum);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "procMsg", xmlWriter);

            if (localProcMsg == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "procMsg cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localProcMsg);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "procStatus", xmlWriter);

            if (localProcStatus == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "procStatus cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localProcStatus);
            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
                                       java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
                                    java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
                                    java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
                                         java.lang.String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                java.lang.String namespace)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static CreatedOrder_Output parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws java.lang.Exception {
                CreatedOrder_Output object = new CreatedOrder_Output();

                int event;
                javax.xml.namespace.QName currentQName = null;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                            if (!"createdOrder_Output".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                        .getNamespaceURI(nsPrefix);

                                return (CreatedOrder_Output) ExtensionMapper.getTypeObject(nsUri,
                                        type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "orderamt").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "orderamt").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "orderamt" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setOrderamt(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "orderid").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "orderid").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "orderid" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setOrderid(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "ordernum").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "ordernum").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "ordernum" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setOrdernum(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "procMsg").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "procMsg").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "procMsg" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setProcMsg(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "procStatus").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "procStatus").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "procStatus" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setProcStatus(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ListOfHuhuOrderLineMessage implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = listOfHuhuOrderLineMessage
           Namespace URI = http://www.siebel.com/xml/HUHU%20Order%20Line%20Message
           Namespace Prefix = ns1
         */

        /**
         * field for ListOforderEntryLineItems
         */
        protected ListOforderEntryLineItems localListOforderEntryLineItems;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localListOforderEntryLineItemsTracker = false;

        private static java.lang.String generatePrefix(
                java.lang.String namespace) {
            if (namespace.equals(
                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        public boolean isListOforderEntryLineItemsSpecified() {
            return localListOforderEntryLineItemsTracker;
        }

        /**
         * Auto generated getter method
         * @return ListOforderEntryLineItems
         */
        public ListOforderEntryLineItems getListOforderEntryLineItems() {
            return localListOforderEntryLineItems;
        }

        /**
         * Auto generated setter method
         * @param param ListOforderEntryLineItems
         */
        public void setListOforderEntryLineItems(
                ListOforderEntryLineItems param) {
            localListOforderEntryLineItemsTracker = param != null;

            this.localListOforderEntryLineItems = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                    xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":listOfHuhuOrderLineMessage",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "listOfHuhuOrderLineMessage", xmlWriter);
                }
            }

            if (localListOforderEntryLineItemsTracker) {
                if (localListOforderEntryLineItems == null) {
                    throw new org.apache.axis2.databinding.ADBException(
                            "listOforderEntry-LineItems cannot be null!!");
                }

                localListOforderEntryLineItems.serialize(new javax.xml.namespace.QName(
                        "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                        "listOforderEntry-LineItems"), xmlWriter);
            }

            xmlWriter.writeEndElement();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
                                       java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
                                    java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
                                    java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
                                         java.lang.String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                java.lang.String namespace)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ListOfHuhuOrderLineMessage parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws java.lang.Exception {
                ListOfHuhuOrderLineMessage object = new ListOfHuhuOrderLineMessage();

                int event;
                javax.xml.namespace.QName currentQName = null;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                            if (!"listOfHuhuOrderLineMessage".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                        .getNamespaceURI(nsPrefix);

                                return (ListOfHuhuOrderLineMessage) ExtensionMapper.getTypeObject(nsUri,
                                        type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "listOforderEntry-LineItems").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("",
                                    "listOforderEntry-LineItems").equals(
                                    reader.getName())) {
                        object.setListOforderEntryLineItems(ListOforderEntryLineItems.Factory.parse(
                                reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class CreatedOrder_Input implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://siebel.com/CustomUI",
                "createdOrder_Input", "ns2");

        /**
         * field for Pricelstid
         */
        protected java.lang.String localPricelstid;

        /**
         * field for Contactid
         */
        protected java.lang.String localContactid = "";

        /**
         * field for Name
         */
        protected java.lang.String localName;

        /**
         * field for Reserve1
         */
        protected java.lang.String localReserve1 = "";

        /**
         * field for ListOfHuhuOrderLineMessage
         */
        protected ListOfHuhuOrderLineMessage localListOfHuhuOrderLineMessage;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localListOfHuhuOrderLineMessageTracker = false;

        /**
         * field for Orderid
         */
        protected java.lang.String localOrderid = "";

        /**
         * field for State
         */
        protected java.lang.String localState;

        /*
         * field for Phonenum
         */
        protected java.lang.String localPhonenum;

        /**
         * field for Reserve5
         */
        protected java.lang.String localReserve5 = "";

        /**
         * field for City
         */
        protected java.lang.String localCity;

        /**
         * field for Unit
         */
        protected java.lang.String localUnit;

        /**
         * field for Longtitude
         */
        protected java.lang.String localLongtitude = "";

        /**
         * field for Accntid
         */
        protected java.lang.String localAccntid;

        /**
         * field for Desc
         */
        protected java.lang.String localDesc = "";

        /**
         * field for Latitude
         */
        protected java.lang.String localLatitude = "";

        /**
         * field for Reserve2
         */
        protected java.lang.String localReserve2 = "";

        /**
         * field for Reserve4
         */
        protected java.lang.String localReserve4 = "";

        /**
         * field for Block
         */
        protected java.lang.String localBlock;

        /**
         * field for Addr
         */
        protected java.lang.String localAddr;

        /**
         * field for Addrid
         */
        protected java.lang.String localAddrid = "";

        /**
         * field for Aliasname
         */
        protected java.lang.String localAliasname = "";

        /**
         * field for Reserve3
         */
        protected java.lang.String localReserve3 = "";

        private static java.lang.String generatePrefix(
                java.lang.String namespace) {
            if (namespace.equals("http://siebel.com/CustomUI")) {
                return "ns2";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getPricelstid() {
            return localPricelstid;
        }

        /**
         * Auto generated setter method
         * @param param Pricelstid
         */
        public void setPricelstid(java.lang.String param) {
            this.localPricelstid = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getContactid() {
            return localContactid;
        }

        /**
         * Auto generated setter method
         * @param param Contactid
         */
        public void setContactid(java.lang.String param) {
            this.localContactid = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getName() {
            return localName;
        }

        /**
         * Auto generated setter method
         * @param param Name
         */
        public void setName(java.lang.String param) {
            this.localName = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReserve1() {
            return localReserve1;
        }

        /**
         * Auto generated setter method
         * @param param Reserve1
         */
        public void setReserve1(java.lang.String param) {
            this.localReserve1 = param;
        }

        public boolean isListOfHuhuOrderLineMessageSpecified() {
            return localListOfHuhuOrderLineMessageTracker;
        }

        /**
         * Auto generated getter method
         * @return ListOfHuhuOrderLineMessage
         */
        public ListOfHuhuOrderLineMessage getListOfHuhuOrderLineMessage() {
            return localListOfHuhuOrderLineMessage;
        }

        /**
         * Auto generated setter method
         * @param param ListOfHuhuOrderLineMessage
         */
        public void setListOfHuhuOrderLineMessage(
                ListOfHuhuOrderLineMessage param) {
            localListOfHuhuOrderLineMessageTracker = param != null;

            this.localListOfHuhuOrderLineMessage = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getOrderid() {
            return localOrderid;
        }

        /**
         * Auto generated setter method
         * @param param Orderid
         */
        public void setOrderid(java.lang.String param) {
            this.localOrderid = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getState() {
            return localState;
        }

        /**
         * Auto generated setter method
         * @param param State
         */
        public void setState(java.lang.String param) {
            this.localState = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getPhonenum() {
            return localPhonenum;
        }

        /**
         * Auto generated setter method
         * @param param Phonenum
         */
        public void setPhonenum(java.lang.String param) {
            this.localPhonenum = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReserve5() {
            return localReserve5;
        }

        /**
         * Auto generated setter method
         * @param param Reserve5
         */
        public void setReserve5(java.lang.String param) {
            this.localReserve5 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getCity() {
            return localCity;
        }

        /**
         * Auto generated setter method
         * @param param City
         */
        public void setCity(java.lang.String param) {
            this.localCity = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getUnit() {
            return localUnit;
        }

        /**
         * Auto generated setter method
         * @param param Unit
         */
        public void setUnit(java.lang.String param) {
            this.localUnit = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getLongtitude() {
            return localLongtitude;
        }

        /**
         * Auto generated setter method
         * @param param Longtitude
         */
        public void setLongtitude(java.lang.String param) {
            this.localLongtitude = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getAccntid() {
            return localAccntid;
        }

        /**
         * Auto generated setter method
         * @param param Accntid
         */
        public void setAccntid(java.lang.String param) {
            this.localAccntid = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getDesc() {
            return localDesc;
        }

        /**
         * Auto generated setter method
         * @param param Desc
         */
        public void setDesc(java.lang.String param) {
            this.localDesc = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getLatitude() {
            return localLatitude;
        }

        /**
         * Auto generated setter method
         * @param param Latitude
         */
        public void setLatitude(java.lang.String param) {
            this.localLatitude = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReserve2() {
            return localReserve2;
        }

        /**
         * Auto generated setter method
         * @param param Reserve2
         */
        public void setReserve2(java.lang.String param) {
            this.localReserve2 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReserve4() {
            return localReserve4;
        }

        /**
         * Auto generated setter method
         * @param param Reserve4
         */
        public void setReserve4(java.lang.String param) {
            this.localReserve4 = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getBlock() {
            return localBlock;
        }

        /**
         * Auto generated setter method
         * @param param Block
         */
        public void setBlock(java.lang.String param) {
            this.localBlock = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getAddr() {
            return localAddr;
        }

        /**
         * Auto generated setter method
         * @param param Addr
         */
        public void setAddr(java.lang.String param) {
            this.localAddr = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getAddrid() {
            return localAddrid;
        }

        /**
         * Auto generated setter method
         * @param param Addrid
         */
        public void setAddrid(java.lang.String param) {
            this.localAddrid = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getAliasname() {
            return localAliasname;
        }

        /**
         * Auto generated setter method
         * @param param Aliasname
         */
        public void setAliasname(java.lang.String param) {
            this.localAliasname = param;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getReserve3() {
            return localReserve3;
        }

        /**
         * Auto generated setter method
         * @param param Reserve3
         */
        public void setReserve3(java.lang.String param) {
            this.localReserve3 = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                    xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://siebel.com/CustomUI");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":createdOrder_Input", xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "createdOrder_Input", xmlWriter);
                }
            }

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "pricelstid", xmlWriter);

            if (localPricelstid == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "pricelstid cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localPricelstid);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "contactid", xmlWriter);

            if (localContactid == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "contactid cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localContactid);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "name", xmlWriter);

            if (localName == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "name cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localName);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "reserve1", xmlWriter);

            if (localReserve1 == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "reserve1 cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localReserve1);
            }

            xmlWriter.writeEndElement();

            if (localListOfHuhuOrderLineMessageTracker) {
                if (localListOfHuhuOrderLineMessage == null) {
                    throw new org.apache.axis2.databinding.ADBException(
                            "listOfHuhuOrderLineMessage cannot be null!!");
                }

                localListOfHuhuOrderLineMessage.serialize(new javax.xml.namespace.QName(
                        "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                        "listOfHuhuOrderLineMessage"), xmlWriter);
            }

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "orderid", xmlWriter);

            if (localOrderid == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "orderid cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localOrderid);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "state", xmlWriter);

            if (localState == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "state cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localState);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "phonenum", xmlWriter);

            if (localPhonenum == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "phonenum cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localPhonenum);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "reserve5", xmlWriter);

            if (localReserve5 == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "reserve5 cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localReserve5);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "city", xmlWriter);

            if (localCity == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "city cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localCity);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "unit", xmlWriter);

            if (localUnit == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "unit cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localUnit);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "longtitude", xmlWriter);

            if (localLongtitude == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "longtitude cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localLongtitude);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "accntid", xmlWriter);

            if (localAccntid == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "accntid cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localAccntid);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "desc", xmlWriter);

            if (localDesc == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "desc cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localDesc);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "latitude", xmlWriter);

            if (localLatitude == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "latitude cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localLatitude);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "reserve2", xmlWriter);

            if (localReserve2 == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "reserve2 cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localReserve2);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "reserve4", xmlWriter);

            if (localReserve4 == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "reserve4 cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localReserve4);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "block", xmlWriter);

            if (localBlock == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "block cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localBlock);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "addr", xmlWriter);

            if (localAddr == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "addr cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localAddr);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "addrid", xmlWriter);

            if (localAddrid == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "addrid cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localAddrid);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "aliasname", xmlWriter);

            if (localAliasname == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "aliasname cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localAliasname);
            }

            xmlWriter.writeEndElement();

            namespace = "http://siebel.com/CustomUI";
            writeStartElement(null, namespace, "reserve3", xmlWriter);

            if (localReserve3 == null) {
                // write the nil attribute
                throw new org.apache.axis2.databinding.ADBException(
                        "reserve3 cannot be null!!");
            } else {
                xmlWriter.writeCharacters(localReserve3);
            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
                                       java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
                                    java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
                                    java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
                                         java.lang.String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                java.lang.String namespace)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static CreatedOrder_Input parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws java.lang.Exception {
                CreatedOrder_Input object = new CreatedOrder_Input();

                int event;
                javax.xml.namespace.QName currentQName = null;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                            if (!"createdOrder_Input".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                        .getNamespaceURI(nsPrefix);

                                return (CreatedOrder_Input) ExtensionMapper.getTypeObject(nsUri,
                                        type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "pricelstid").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "pricelstid").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "pricelstid" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setPricelstid(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "contactid").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "contactid").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "contactid" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setContactid(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "name").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "name").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "name" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "reserve1").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "reserve1").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "reserve1" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setReserve1(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "listOfHuhuOrderLineMessage").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("",
                                    "listOfHuhuOrderLineMessage").equals(
                                    reader.getName())) {
                        object.setListOfHuhuOrderLineMessage(ListOfHuhuOrderLineMessage.Factory.parse(
                                reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "orderid").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "orderid").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "orderid" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setOrderid(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "state").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "state").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "state" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setState(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "phonenum").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "phonenum").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "phonenum" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setPhonenum(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "reserve5").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "reserve5").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "reserve5" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setReserve5(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "city").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "city").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "city" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setCity(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "unit").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "unit").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "unit" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setUnit(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "longtitude").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "longtitude").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "longtitude" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setLongtitude(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "accntid").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "accntid").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "accntid" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setAccntid(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "desc").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "desc").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "desc" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setDesc(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "latitude").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "latitude").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "latitude" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setLatitude(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "reserve2").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "reserve2").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "reserve2" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setReserve2(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "reserve4").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "reserve4").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "reserve4" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setReserve4(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "block").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "block").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "block" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setBlock(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "addr").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "addr").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "addr" + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setAddr(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "addrid").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "addrid").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "addrid" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setAddrid(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "aliasname").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "aliasname").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "aliasname" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setAliasname(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://siebel.com/CustomUI", "reserve3").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("", "reserve3").equals(
                                    reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                    "The element: " + "reserve3" +
                                            "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setReserve3(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ListOfHuhuOrderLineMessageTopElmt implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = listOfHuhuOrderLineMessageTopElmt
           Namespace URI = http://www.siebel.com/xml/HUHU%20Order%20Line%20Message
           Namespace Prefix = ns1
         */

        /**
         * field for ListOfHuhuOrderLineMessage
         */
        protected ListOfHuhuOrderLineMessage localListOfHuhuOrderLineMessage;

        private static java.lang.String generatePrefix(
                java.lang.String namespace) {
            if (namespace.equals(
                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Auto generated getter method
         * @return ListOfHuhuOrderLineMessage
         */
        public ListOfHuhuOrderLineMessage getListOfHuhuOrderLineMessage() {
            return localListOfHuhuOrderLineMessage;
        }

        /**
         * Auto generated setter method
         * @param param ListOfHuhuOrderLineMessage
         */
        public void setListOfHuhuOrderLineMessage(
                ListOfHuhuOrderLineMessage param) {
            this.localListOfHuhuOrderLineMessage = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                    xmlWriter);

            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                        "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":listOfHuhuOrderLineMessageTopElmt",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "listOfHuhuOrderLineMessageTopElmt", xmlWriter);
                }
            }

            if (localListOfHuhuOrderLineMessage == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "listOfHuhuOrderLineMessage cannot be null!!");
            }

            localListOfHuhuOrderLineMessage.serialize(new javax.xml.namespace.QName(
                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                    "listOfHuhuOrderLineMessage"), xmlWriter);

            xmlWriter.writeEndElement();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix,
                                       java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,
                                    java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                        attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,
                                    java.lang.String attName, java.lang.String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                        namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace,
                                         java.lang.String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            java.lang.String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                        attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                            qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                java.lang.String namespace)
                throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ListOfHuhuOrderLineMessageTopElmt parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws java.lang.Exception {
                ListOfHuhuOrderLineMessageTopElmt object = new ListOfHuhuOrderLineMessageTopElmt();

                int event;
                javax.xml.namespace.QName currentQName = null;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                            if (!"listOfHuhuOrderLineMessageTopElmt".equals(
                                    type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                        .getNamespaceURI(nsPrefix);

                                return (ListOfHuhuOrderLineMessageTopElmt) ExtensionMapper.getTypeObject(nsUri,
                                        type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName(
                                    "http://www.siebel.com/xml/HUHU%20Order%20Line%20Message",
                                    "listOfHuhuOrderLineMessage").equals(
                                    reader.getName())) ||
                            new javax.xml.namespace.QName("",
                                    "listOfHuhuOrderLineMessage").equals(
                                    reader.getName())) {
                        object.setListOfHuhuOrderLineMessage(ListOfHuhuOrderLineMessage.Factory.parse(
                                reader));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                        // 1 - A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }
        } //end of factory class
    }
}
