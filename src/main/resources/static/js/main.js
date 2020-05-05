var productApi = Vue.resource('/product');
var courtApi = Vue.resource('/court/findByProductId{/productId}');
var vendorApi = Vue.resource('/vendor/findByCourtId{/courtId}');
var workflowApi = Vue.resource('/workflow/findByProductId{/productId}');
var mqRequestApi = Vue.resource('/mqrequest{/type}');


const product = Vue.observable({ id: {} });
Object.defineProperty(Vue.prototype, '$product', {
    get () {return product.id},
    set (value) {product.id = value}
});

const court = Vue.observable({ id: {} });
Object.defineProperty(Vue.prototype, '$court', {
    get () {return court.id},
    set (value) {court.id = value}
});

const vendor = Vue.observable({ id: {} });
Object.defineProperty(Vue.prototype, '$vendor', {
    get () {return vendor.id},
    set (value) {vendor.id = value}
});

const workflow = Vue.observable({ name: {} });
Object.defineProperty(Vue.prototype, '$workflow', {
    get () {return workflow.name},
    set (value) {workflow.name = value}
});

const request = Vue.observable({ name: {} });
Object.defineProperty(Vue.prototype, '$request', {
    get () {return request.name},
    set (value) {request.name = value}
});

const process = Vue.observable({ name: {} });
Object.defineProperty(Vue.prototype, '$process', {
    get () {return process.name},
    set (value) {process.name = value}
});

const initiator = Vue.observable({ name: {} });
Object.defineProperty(Vue.prototype, '$initiator', {
    get () {return initiator.name},
    set (value) {initiator.name = value}
});

const filelocation = Vue.observable({ path: {} });
Object.defineProperty(Vue.prototype, '$filelocation', {
    get () {return filelocation.path},
    set (value) {filelocation.path = value}
});

const fifooverride = Vue.observable({ value: {} });
Object.defineProperty(Vue.prototype, '$fifooverride', {
    get () {return fifooverride.value},
    set (value) {fifooverride.value = value}
});

const aqtimeoverride = Vue.observable({ value: {} });
Object.defineProperty(Vue.prototype, '$aqtimeoverride', {
    get () {return aqtimeoverride.value},
    set (value) {aqtimeoverride.value = value}
});

Vue.component('product-list', {
    props: ['products'],
    template:
        '<div class="w3-padding-small">' +
        '<div class="w3-col" style="width:220px">Product:</div>' +
        '<select class="w3-select w3-border w3-light-grey" style="width:435px" v-model="selected" v-on:change="save">' +
        '<option v-bind:value="product.id" v-for="product in products" >' +
        '{{ product.displayName }}' +
        '</option>' +
        '</select></div>',
    data: function() {
        return {
            selected: ''
        };
    },
    methods: {
        save: function() {
            this.$product = this.selected;
        }
    }
});

Vue.component('court-list', {
    props: ['courts'],
    template: '<div class="w3-padding-small"><div class="w3-col" style="width:220px">Court:</div>' +
        '<select class="w3-select w3-border w3-light-grey" style="width:435px" v-model="selected" v-on:change="save">' +
        '<option v-bind:value="court.id" v-for="court in courts" >' +
        '{{ court.displayName }}' +
        '</option>' +
        '</select></div>',
    data: function() {
        return {
            selected: ''
        };
    },
    methods: {
        save: function() {
            this.$court = this.selected
        }
    }
});

Vue.component('vendor-list', {
    props: ['vendors'],
    template: '<div class="w3-padding-small"><div class="w3-col" style="width:220px">Vendor:</div>' +
        '<select class="w3-select w3-border w3-light-grey" style="width:435px" v-model="selected" v-on:change="save">' +
        '<option v-bind:value="vendor.id" v-for="vendor in vendors" >' +
        '{{ vendor.displayName }}' +
        '</option>' +
        '</select></div>',
    data: function() {
        return {
            selected: ''
        };
    },
    methods: {
        save: function() {
            this.$vendor = this.selected
        }
    }
});

Vue.component('workflow-list', {
    props: ['workflows'],
    template: '<div class="w3-padding-small"><div class="w3-col" style="width:220px">Workflow Type:</div>' +
        '<select class="w3-select w3-border w3-light-grey" style="width:435px" v-model="selected" v-on:change="save">' +
        '<option v-for="workflow in workflows" >' +
        '{{ workflow }}' +
        '</option>' +
        '</select></div>',
    data: function() {
        return {
            selected: ''
        };
    },
    methods: {
        save: function() {
            this.$workflow = this.selected;
        }
    }
});

Vue.component('process-list', {
    props: ['processes'],
    template: '<div class="w3-padding-small"><div class="w3-col" style="width:220px">Process to run:</div>' +
        '<select class="w3-select w3-border w3-light-grey" style="width:435px" v-model="selected" v-on:change="save">' +
        '<option v-for="process in processes" >' +
        '{{ process }}' +
        '</option>' +
        '</select></div>',
    data: function() {
        return {
            selected: ''
        };
    },
    methods: {
        save: function() {
            this.$process = this.selected;
        }
    }
});

Vue.component('initiator-list', {
    props: ['initiators'],
    template: '<div class="w3-padding-small"><div class="w3-col" style="width:220px">Request initiator type:</div>' +
        '<select class="w3-select w3-border w3-light-grey" style="width:435px" v-model="selected" v-on:change="save">' +
        '<option v-for="initiator in initiators" >' +
        '{{ initiator }}' +
        '</option>' +
        '</select></div>',
    data: function() {
        return {
            selected: ''
        };
    },
    methods: {
        save: function() {
            this.$initiator = this.selected;
        }
    }
});

var productApp = new Vue({
    el: '#product-list',
    template: '<product-list :products="products"/>',
    data: {
        products: []
    },
    created: function() {
        productApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message => this.products.push(message))
            ));
        this.$fifooverride = false;
        this.$aqtimeoverride = false
    }
});

var courtApp = new Vue({
    el: '#court-list',
    template: '<court-list :courts="courts"/>',
    data: {
        courts: []
    },
    watch: {
        $product () {
            this.courts = [];
            courtApi.get({productId: product.id}).then(result =>
                result.json().then(data =>
                    data.forEach(message => this.courts.push(message))
                ))
        }
    }
});

var vendorApp = new Vue({
    el: '#vendor-list',
    template: '<vendor-list :vendors="vendors"/>',
    data: {
        vendors: []
    },
    watch: {
        $court () {
            this.vendors = [];
            vendorApi.get({courtId: court.id}).then(result =>
                result.json().then(data =>
                    data.forEach(message => this.vendors.push(message))
                ))
        },
        $product () {
            this.vendors = []
        }
    }
});

var workflowTypeApp = new Vue({
    el: '#workflow-list',
    template: '<workflow-list :workflows="workflows"/>',
    data: {
        workflows: []
    },
    watch: {
        $product () {
            this.workflows = [];
            workflowApi.get({productId: product.id}).then(result =>
                result.json().then(data =>
                    data.forEach(message => this.workflows.push(message))
                ))
        }
    }
});

var processesApp = new Vue({
    el: '#process-list',
    template: '<process-list :processes="processes"/>',
    data: {
        processes: [
           "PP", "PP-IC", "PP-IC-PB", "PP-IC-PB-NL"
        ]
    }
});

var initiatorApp = new Vue({
    el: '#initiator-list',
    template: '<initiator-list :initiators="initiators"/>',
    data: {
        initiators: [
            "ARCHIVE", "CUSTOM", "DAILY", "RESCRAPE", "UPDATE LINK", "LEGACY"
        ]
    }
});

var requestNameApp = new Vue({
    el: '#request-name',
    template:
        '<div class="w3-padding-small">' +
        '<div class="w3-col" style="width:220px">Request name:</div>' +
        '<input class="w3-input w3-border w3-light-grey" style="width:435px" type="text" v-model="request"/>' +
        '<div v-if="error"><font size="2" color="red">Request name cannot contain any space(s) or slash character(s). Please re-enter a valid request name.</font></div>' +
        '</div>',
    data: {
        request: '',
        error: false
    },
    updated: function() {
        if (this.request.includes(' ') || this.request.includes('/') || this.request.includes('\\')) {
            this.error = true;
            this.$request = ''
        } else {
            this.error = false;
            this.$request = this.request
        }
    }
});

var fileLocationApp = new Vue({
    el: '#file-location',
    template:
        '<div class="w3-padding-small">' +
        '<div class="w3-col" style="width:220px">File location:</div>' +
        '<input class="w3-input w3-border w3-light-grey" style="width:435px" type="text" v-model="filelocation"/></div>',
    data: {
        filelocation: '',
    },
    updated: function() {
            this.$filelocation = this.filelocation
    }
});

var fifoOverrideApp = new Vue({
    el: '#fifo-override',
    template: '<div class="w3-padding-small"><div class="w3-col" style="width:220px">FIFO Override:</div>' +
        '<input class="w3-check" type="checkbox" v-model="fifooverride"></div>',
    data: {
        fifooverride: false,
    },
    updated: function() {
        this.$fifooverride = this.fifooverride
    }
});

var aqTimeOverrideApp = new Vue({
    el: '#aq-time-override',
    template: '<div class="w3-padding-small"><div class="w3-col" style="width:220px">Acquisition Time Override:</div>' +
        '<input class="w3-check" type="checkbox" v-model="aqtimeoverride"></div>',
    data: {
        aqtimeoverride: false,
    },
    updated: function() {
        this.$aqtimeoverride = this.aqtimeoverride
    }
});

var send = new Vue({
    el: '#prepareAndSend',
    template:
        '<div>' +
            '<input type="button" class="w3-btn w3-ripple w3-light-green" value="Prepare request"  @click="prepare">' +
            '<div v-if="xmlMqRequestFormatted">' +
                '<p><textarea readonly="true" rows="16" cols="100">{{xmlMqRequestFormatted}}</textarea></p>' +
                '<input type="button" class="w3-btn w3-ripple w3-light-green" value="Send to MQ"  @click="send">' +
        '   </div>' +
        '</div>',
    data: {
        xmlMqRequest: '',
        xmlMqRequestFormatted: ''
    },
    methods: {
        prepare: function () {
            var obj = {};
            obj.sourceFile = this.$filelocation;
            obj.courtId = this.$court;
            obj.workflowType = this.$workflow;
            obj.requestInitiatorType = this.$initiator;
            obj.productId = this.$product;
            obj.fifoOverride = this.$fifooverride;
            obj.aqTimeOverride = this.$aqtimeoverride;
            obj.vendorId = this.$vendor;
            obj.requestType = this.$process;
            obj.requestName = this.$request;

            mqRequestApi.save({type: 'prepare'}, obj).then(response => {
                response.json().then(data => {
                    this.xmlMqRequest = data.mqRequest;
                    this.xmlMqRequestFormatted = formatXml(data.mqRequest);
                })
            }, response => {
                alert("Cannot create MQ-Request due to unexpected exception")
            });
        },
        send: function () {
            mqRequestApi.save({type: 'send'}, this.xmlMqRequest).then(response => {
                alert("Request successfully sent to MQ")
            }, response => {
                alert("Cannot send MQ-Request due to unexpected exception")
            });
        }
    }
});

function formatXml(xml) {
    var formatted = '', indent= '';
    var tab = '\t';
    xml.split(/>\s*</).forEach(function(node) {
        if (node.match( /^\/\w/ )) indent = indent.substring(tab.length);
        formatted += indent + '<' + node + '>\r\n';
        if (node.match( /^<?\w[^>]*[^\/]$/ )) indent += tab;
    });
    return formatted.substring(1, formatted.length-3);
}
