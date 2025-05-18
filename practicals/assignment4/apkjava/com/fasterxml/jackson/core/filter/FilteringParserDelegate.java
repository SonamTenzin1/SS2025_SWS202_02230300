package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public class FilteringParserDelegate extends JsonParserDelegate {
    protected boolean _allowMultipleMatches;
    protected JsonToken _currToken;
    protected TokenFilterContext _exposedContext;
    protected TokenFilterContext _headContext;

    @Deprecated
    protected boolean _includeImmediateParent;
    protected boolean _includePath;
    protected TokenFilter _itemFilter;
    protected JsonToken _lastClearedToken;
    protected TokenFilter rootFilter;

    public FilteringParserDelegate(JsonParser jsonParser, TokenFilter tokenFilter, boolean z, boolean z2) {
        super(jsonParser);
        this.rootFilter = tokenFilter;
        this._itemFilter = tokenFilter;
        this._headContext = TokenFilterContext.createRootContext(tokenFilter);
        this._includePath = z;
        this._allowMultipleMatches = z2;
    }

    private JsonToken _nextBuffered(TokenFilterContext tokenFilterContext) throws IOException {
        this._exposedContext = tokenFilterContext;
        JsonToken nextTokenToRead = tokenFilterContext.nextTokenToRead();
        if (nextTokenToRead != null) {
            return nextTokenToRead;
        }
        while (tokenFilterContext != this._headContext) {
            tokenFilterContext = this._exposedContext.findChildOf(tokenFilterContext);
            this._exposedContext = tokenFilterContext;
            if (tokenFilterContext != null) {
                JsonToken nextTokenToRead2 = tokenFilterContext.nextTokenToRead();
                if (nextTokenToRead2 != null) {
                    return nextTokenToRead2;
                }
            } else {
                throw _constructError("Unexpected problem: chain of filtered context broken");
            }
        }
        throw _constructError("Internal error: failed to locate expected buffered tokens");
    }

    protected JsonStreamContext _filterContext() {
        TokenFilterContext tokenFilterContext = this._exposedContext;
        return tokenFilterContext != null ? tokenFilterContext : this._headContext;
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x003c, code lost:
    
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x003e, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final JsonToken _nextToken2() throws IOException {
        TokenFilter checkValue;
        JsonToken _nextTokenWithBuffering;
        JsonToken _nextTokenWithBuffering2;
        JsonToken _nextTokenWithBuffering3;
        while (true) {
            JsonToken nextToken = this.delegate.nextToken();
            if (nextToken == null) {
                this._currToken = nextToken;
                return nextToken;
            }
            int id = nextToken.id();
            if (id != 1) {
                if (id != 2) {
                    if (id == 3) {
                        TokenFilter tokenFilter = this._itemFilter;
                        TokenFilter tokenFilter2 = TokenFilter.INCLUDE_ALL;
                        if (tokenFilter == tokenFilter2) {
                            this._headContext = this._headContext.createChildArrayContext(tokenFilter, true);
                            this._currToken = nextToken;
                            return nextToken;
                        }
                        if (tokenFilter == null) {
                            this.delegate.skipChildren();
                        } else {
                            TokenFilter checkValue2 = this._headContext.checkValue(tokenFilter);
                            if (checkValue2 == null) {
                                this.delegate.skipChildren();
                            } else {
                                if (checkValue2 != tokenFilter2) {
                                    checkValue2 = checkValue2.filterStartArray();
                                }
                                this._itemFilter = checkValue2;
                                if (checkValue2 == tokenFilter2) {
                                    this._headContext = this._headContext.createChildArrayContext(checkValue2, true);
                                    this._currToken = nextToken;
                                    return nextToken;
                                }
                                TokenFilterContext createChildArrayContext = this._headContext.createChildArrayContext(checkValue2, false);
                                this._headContext = createChildArrayContext;
                                if (this._includePath && (_nextTokenWithBuffering2 = _nextTokenWithBuffering(createChildArrayContext)) != null) {
                                    this._currToken = _nextTokenWithBuffering2;
                                    return _nextTokenWithBuffering2;
                                }
                            }
                        }
                    } else if (id != 4) {
                        if (id != 5) {
                            TokenFilter tokenFilter3 = this._itemFilter;
                            TokenFilter tokenFilter4 = TokenFilter.INCLUDE_ALL;
                            if (tokenFilter3 == tokenFilter4) {
                                this._currToken = nextToken;
                                return nextToken;
                            }
                            if (tokenFilter3 != null && ((checkValue = this._headContext.checkValue(tokenFilter3)) == tokenFilter4 || (checkValue != null && checkValue.includeValue(this.delegate)))) {
                                break;
                            }
                        } else {
                            String currentName = this.delegate.getCurrentName();
                            TokenFilter fieldName = this._headContext.setFieldName(currentName);
                            TokenFilter tokenFilter5 = TokenFilter.INCLUDE_ALL;
                            if (fieldName == tokenFilter5) {
                                this._itemFilter = fieldName;
                                this._currToken = nextToken;
                                return nextToken;
                            }
                            if (fieldName == null) {
                                this.delegate.nextToken();
                                this.delegate.skipChildren();
                            } else {
                                TokenFilter includeProperty = fieldName.includeProperty(currentName);
                                if (includeProperty == null) {
                                    this.delegate.nextToken();
                                    this.delegate.skipChildren();
                                } else {
                                    this._itemFilter = includeProperty;
                                    if (includeProperty == tokenFilter5) {
                                        if (this._includePath) {
                                            this._currToken = nextToken;
                                            return nextToken;
                                        }
                                    } else if (this._includePath && (_nextTokenWithBuffering = _nextTokenWithBuffering(this._headContext)) != null) {
                                        this._currToken = _nextTokenWithBuffering;
                                        return _nextTokenWithBuffering;
                                    }
                                }
                            }
                        }
                    }
                }
                boolean isStartHandled = this._headContext.isStartHandled();
                TokenFilter filter = this._headContext.getFilter();
                if (filter != null && filter != TokenFilter.INCLUDE_ALL) {
                    filter.filterFinishArray();
                }
                TokenFilterContext parent = this._headContext.getParent();
                this._headContext = parent;
                this._itemFilter = parent.getFilter();
                if (isStartHandled) {
                    this._currToken = nextToken;
                    return nextToken;
                }
            } else {
                TokenFilter tokenFilter6 = this._itemFilter;
                TokenFilter tokenFilter7 = TokenFilter.INCLUDE_ALL;
                if (tokenFilter6 == tokenFilter7) {
                    this._headContext = this._headContext.createChildObjectContext(tokenFilter6, true);
                    this._currToken = nextToken;
                    return nextToken;
                }
                if (tokenFilter6 == null) {
                    this.delegate.skipChildren();
                } else {
                    TokenFilter checkValue3 = this._headContext.checkValue(tokenFilter6);
                    if (checkValue3 == null) {
                        this.delegate.skipChildren();
                    } else {
                        if (checkValue3 != tokenFilter7) {
                            checkValue3 = checkValue3.filterStartObject();
                        }
                        this._itemFilter = checkValue3;
                        if (checkValue3 == tokenFilter7) {
                            this._headContext = this._headContext.createChildObjectContext(checkValue3, true);
                            this._currToken = nextToken;
                            return nextToken;
                        }
                        TokenFilterContext createChildObjectContext = this._headContext.createChildObjectContext(checkValue3, false);
                        this._headContext = createChildObjectContext;
                        if (this._includePath && (_nextTokenWithBuffering3 = _nextTokenWithBuffering(createChildObjectContext)) != null) {
                            this._currToken = _nextTokenWithBuffering3;
                            return _nextTokenWithBuffering3;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0040, code lost:
    
        return _nextBuffered(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final JsonToken _nextTokenWithBuffering(TokenFilterContext tokenFilterContext) throws IOException {
        TokenFilter checkValue;
        while (true) {
            JsonToken nextToken = this.delegate.nextToken();
            if (nextToken == null) {
                return nextToken;
            }
            int id = nextToken.id();
            boolean z = false;
            if (id != 1) {
                if (id != 2) {
                    if (id == 3) {
                        TokenFilter checkValue2 = this._headContext.checkValue(this._itemFilter);
                        if (checkValue2 == null) {
                            this.delegate.skipChildren();
                        } else {
                            TokenFilter tokenFilter = TokenFilter.INCLUDE_ALL;
                            if (checkValue2 != tokenFilter) {
                                checkValue2 = checkValue2.filterStartArray();
                            }
                            this._itemFilter = checkValue2;
                            if (checkValue2 == tokenFilter) {
                                this._headContext = this._headContext.createChildArrayContext(checkValue2, true);
                                return _nextBuffered(tokenFilterContext);
                            }
                            this._headContext = this._headContext.createChildArrayContext(checkValue2, false);
                        }
                    } else if (id != 4) {
                        if (id != 5) {
                            TokenFilter tokenFilter2 = this._itemFilter;
                            TokenFilter tokenFilter3 = TokenFilter.INCLUDE_ALL;
                            if (tokenFilter2 == tokenFilter3) {
                                return _nextBuffered(tokenFilterContext);
                            }
                            if (tokenFilter2 != null && ((checkValue = this._headContext.checkValue(tokenFilter2)) == tokenFilter3 || (checkValue != null && checkValue.includeValue(this.delegate)))) {
                                break;
                            }
                        } else {
                            String currentName = this.delegate.getCurrentName();
                            TokenFilter fieldName = this._headContext.setFieldName(currentName);
                            TokenFilter tokenFilter4 = TokenFilter.INCLUDE_ALL;
                            if (fieldName == tokenFilter4) {
                                this._itemFilter = fieldName;
                                return _nextBuffered(tokenFilterContext);
                            }
                            if (fieldName == null) {
                                this.delegate.nextToken();
                                this.delegate.skipChildren();
                            } else {
                                TokenFilter includeProperty = fieldName.includeProperty(currentName);
                                if (includeProperty == null) {
                                    this.delegate.nextToken();
                                    this.delegate.skipChildren();
                                } else {
                                    this._itemFilter = includeProperty;
                                    if (includeProperty == tokenFilter4) {
                                        return _nextBuffered(tokenFilterContext);
                                    }
                                }
                            }
                        }
                    }
                }
                TokenFilter filter = this._headContext.getFilter();
                if (filter != null && filter != TokenFilter.INCLUDE_ALL) {
                    filter.filterFinishArray();
                }
                TokenFilterContext tokenFilterContext2 = this._headContext;
                boolean z2 = tokenFilterContext2 == tokenFilterContext;
                if (z2 && tokenFilterContext2.isStartHandled()) {
                    z = true;
                }
                TokenFilterContext parent = this._headContext.getParent();
                this._headContext = parent;
                this._itemFilter = parent.getFilter();
                if (z) {
                    return nextToken;
                }
                if (z2 || this._headContext == tokenFilterContext) {
                    return null;
                }
            } else {
                TokenFilter tokenFilter5 = this._itemFilter;
                TokenFilter tokenFilter6 = TokenFilter.INCLUDE_ALL;
                if (tokenFilter5 == tokenFilter6) {
                    this._headContext = this._headContext.createChildObjectContext(tokenFilter5, true);
                    return nextToken;
                }
                if (tokenFilter5 == null) {
                    this.delegate.skipChildren();
                } else {
                    TokenFilter checkValue3 = this._headContext.checkValue(tokenFilter5);
                    if (checkValue3 == null) {
                        this.delegate.skipChildren();
                    } else {
                        if (checkValue3 != tokenFilter6) {
                            checkValue3 = checkValue3.filterStartObject();
                        }
                        this._itemFilter = checkValue3;
                        if (checkValue3 == tokenFilter6) {
                            this._headContext = this._headContext.createChildObjectContext(checkValue3, true);
                            return _nextBuffered(tokenFilterContext);
                        }
                        this._headContext = this._headContext.createChildObjectContext(checkValue3, false);
                    }
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public void clearCurrentToken() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != null) {
            this._lastClearedToken = jsonToken;
            this._currToken = null;
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonToken currentToken() {
        return this._currToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() throws IOException {
        return this.delegate.getBigIntegerValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        return this.delegate.getBinaryValue(base64Variant);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public byte getByteValue() throws IOException {
        return this.delegate.getByteValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        return this.delegate.getCurrentLocation();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String getCurrentName() throws IOException {
        JsonStreamContext _filterContext = _filterContext();
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return _filterContext.getCurrentName();
        }
        JsonStreamContext parent = _filterContext.getParent();
        if (parent == null) {
            return null;
        }
        return parent.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public final int getCurrentTokenId() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.id();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public BigDecimal getDecimalValue() throws IOException {
        return this.delegate.getDecimalValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public double getDoubleValue() throws IOException {
        return this.delegate.getDoubleValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException {
        return this.delegate.getEmbeddedObject();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public float getFloatValue() throws IOException {
        return this.delegate.getFloatValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getIntValue() throws IOException {
        return this.delegate.getIntValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public long getLongValue() throws IOException {
        return this.delegate.getLongValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() throws IOException {
        return this.delegate.getNumberType();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public Number getNumberValue() throws IOException {
        return this.delegate.getNumberValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonStreamContext getParsingContext() {
        return _filterContext();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public short getShortValue() throws IOException {
        return this.delegate.getShortValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException {
        return this.delegate.getText();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException {
        return this.delegate.getTextCharacters();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        return this.delegate.getTextLength();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() throws IOException {
        return this.delegate.getTextOffset();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        return this.delegate.getTokenLocation();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt() throws IOException {
        return this.delegate.getValueAsInt();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong() throws IOException {
        return this.delegate.getValueAsLong();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() throws IOException {
        return this.delegate.getValueAsString();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean hasCurrentToken() {
        return this._currToken != null;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        return this.delegate.hasTextCharacters();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public final boolean hasToken(JsonToken jsonToken) {
        return this._currToken == jsonToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean hasTokenId(int i2) {
        JsonToken jsonToken = this._currToken;
        return jsonToken == null ? i2 == 0 : jsonToken.id() == i2;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedStartArrayToken() {
        return this._currToken == JsonToken.START_ARRAY;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedStartObjectToken() {
        return this._currToken == JsonToken.START_OBJECT;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0115, code lost:
    
        r1 = r6._itemFilter;
        r4 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0119, code lost:
    
        if (r1 != r4) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x011b, code lost:
    
        r6._headContext = r6._headContext.createChildArrayContext(r1, true);
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0125, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0126, code lost:
    
        if (r1 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0128, code lost:
    
        r6.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x012f, code lost:
    
        r1 = r6._headContext.checkValue(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0135, code lost:
    
        if (r1 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0137, code lost:
    
        r6.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x013e, code lost:
    
        if (r1 == r4) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0140, code lost:
    
        r1 = r1.filterStartArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0144, code lost:
    
        r6._itemFilter = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0146, code lost:
    
        if (r1 != r4) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0148, code lost:
    
        r6._headContext = r6._headContext.createChildArrayContext(r1, true);
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0152, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0153, code lost:
    
        r0 = r6._headContext.createChildArrayContext(r1, false);
        r6._headContext = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x015d, code lost:
    
        if (r6._includePath == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x015f, code lost:
    
        r0 = _nextTokenWithBuffering(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0163, code lost:
    
        if (r0 == null) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0165, code lost:
    
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0167, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0168, code lost:
    
        r1 = r6._headContext.isStartHandled();
        r2 = r6._headContext.getFilter();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0174, code lost:
    
        if (r2 == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0178, code lost:
    
        if (r2 == com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x017a, code lost:
    
        r2.filterFinishArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x017d, code lost:
    
        r2 = r6._headContext.getParent();
        r6._headContext = r2;
        r6._itemFilter = r2.getFilter();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x018b, code lost:
    
        if (r1 == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x018d, code lost:
    
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x018f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0190, code lost:
    
        r1 = r6._itemFilter;
        r4 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0194, code lost:
    
        if (r1 != r4) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0196, code lost:
    
        r6._headContext = r6._headContext.createChildObjectContext(r1, true);
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01a0, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01a1, code lost:
    
        if (r1 != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01a3, code lost:
    
        r6.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01a9, code lost:
    
        r1 = r6._headContext.checkValue(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01af, code lost:
    
        if (r1 != null) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01b1, code lost:
    
        r6.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01b7, code lost:
    
        if (r1 == r4) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01b9, code lost:
    
        r1 = r1.filterStartObject();
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01bd, code lost:
    
        r6._itemFilter = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01bf, code lost:
    
        if (r1 != r4) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01c1, code lost:
    
        r6._headContext = r6._headContext.createChildObjectContext(r1, true);
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01cb, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01cc, code lost:
    
        r0 = r6._headContext.createChildObjectContext(r1, false);
        r6._headContext = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01d6, code lost:
    
        if (r6._includePath == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01d8, code lost:
    
        r0 = _nextTokenWithBuffering(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01dc, code lost:
    
        if (r0 == null) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01de, code lost:
    
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01e0, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        r2 = r0.nextTokenToRead();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        r2 = r6._headContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        if (r0 != r2) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
    
        r0 = r2.findChildOf(r0);
        r6._exposedContext = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
    
        if (r0 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:
    
        throw _constructError("Unexpected problem: chain of filtered context broken");
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004c, code lost:
    
        r6._exposedContext = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0052, code lost:
    
        if (r0.inArray() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0054, code lost:
    
        r0 = r6.delegate.getCurrentToken();
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0045, code lost:
    
        r6._currToken = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0047, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006d, code lost:
    
        r0 = r6.delegate.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0073, code lost:
    
        if (r0 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0075, code lost:
    
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0077, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0078, code lost:
    
        r1 = r0.id();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x007e, code lost:
    
        if (r1 == 1) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0081, code lost:
    
        if (r1 == 2) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0084, code lost:
    
        if (r1 == 3) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0087, code lost:
    
        if (r1 == 4) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x008a, code lost:
    
        if (r1 == 5) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x008c, code lost:
    
        r1 = r6._itemFilter;
        r2 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0090, code lost:
    
        if (r1 != r2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0092, code lost:
    
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0094, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0095, code lost:
    
        if (r1 == null) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0097, code lost:
    
        r1 = r6._headContext.checkValue(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x009d, code lost:
    
        if (r1 == r2) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x009f, code lost:
    
        if (r1 == null) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a7, code lost:
    
        if (r1.includeValue(r6.delegate) == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00a9, code lost:
    
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ab, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01e5, code lost:
    
        return _nextToken2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ac, code lost:
    
        r1 = r6.delegate.getCurrentName();
        r2 = r6._headContext.setFieldName(r1);
        r3 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ba, code lost:
    
        if (r2 != r3) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00bc, code lost:
    
        r6._itemFilter = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c0, code lost:
    
        if (r6._includePath != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c4, code lost:
    
        if (r6._includeImmediateParent == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cc, code lost:
    
        if (r6._headContext.isStartHandled() != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00ce, code lost:
    
        r0 = r6._headContext.nextTokenToRead();
        r6._exposedContext = r6._headContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00d8, code lost:
    
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00da, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00db, code lost:
    
        if (r2 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00dd, code lost:
    
        r6.delegate.nextToken();
        r6.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00e9, code lost:
    
        r1 = r2.includeProperty(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00ed, code lost:
    
        if (r1 != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00ef, code lost:
    
        r6.delegate.nextToken();
        r6.delegate.skipChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00fb, code lost:
    
        r6._itemFilter = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00fd, code lost:
    
        if (r1 != r3) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0101, code lost:
    
        if (r6._includePath == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0103, code lost:
    
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0105, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0108, code lost:
    
        if (r6._includePath == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x010a, code lost:
    
        r0 = _nextTokenWithBuffering(r6._headContext);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0110, code lost:
    
        if (r0 == null) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0112, code lost:
    
        r6._currToken = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0114, code lost:
    
        return r0;
     */
    @Override // com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonToken nextToken() throws IOException {
        JsonToken jsonToken;
        if (!this._allowMultipleMatches && (jsonToken = this._currToken) != null && this._exposedContext == null) {
            if (jsonToken.isStructEnd() && this._headContext.isStartHandled()) {
                this._currToken = null;
                return null;
            }
            if (this._currToken.isScalarValue() && !this._headContext.isStartHandled() && !this._includePath && this._itemFilter == TokenFilter.INCLUDE_ALL) {
                this._currToken = null;
                return null;
            }
        }
        TokenFilterContext tokenFilterContext = this._exposedContext;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextValue() throws IOException {
        JsonToken nextToken = nextToken();
        return nextToken == JsonToken.FIELD_NAME ? nextToken() : nextToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        return this.delegate.readBinaryValue(base64Variant, outputStream);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonParser skipChildren() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return this;
        }
        int i2 = 1;
        while (true) {
            JsonToken nextToken = nextToken();
            if (nextToken == null) {
                return this;
            }
            if (nextToken.isStructStart()) {
                i2++;
            } else if (nextToken.isStructEnd() && i2 - 1 == 0) {
                return this;
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt(int i2) throws IOException {
        return this.delegate.getValueAsInt(i2);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong(long j2) throws IOException {
        return this.delegate.getValueAsLong(j2);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException {
        return this.delegate.getValueAsString(str);
    }
}
