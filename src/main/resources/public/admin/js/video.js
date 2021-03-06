var baseUrl = parent.window.baseUrl || '../';

var queryUrl = baseUrl + "api/video/findPage";
var addUrl = baseUrl + "api/video/add";
var modUrl = baseUrl + "api/video/update";
var delUrl = baseUrl + "api/video/delete";
var uploadUrl = baseUrl + "api/file/uploadImg";
var uploadFileUrl = baseUrl + "api/file/uploadFile";
var typeUrl = baseUrl + "api/videotype/findAll";


var ajaxReq = parent.window.ajaxReq || "";

var myvue = new Vue({
	    el: '#app',
	    data: function(){
	    	return {
				filters: {
					mark: '',
					type: ''
				},
				list: [],
				total: 0,
				page: 1,
				rows: 10,
				listLoading: false,
				sels: [],//列表选中列
				typeOptions:[],
				uploadUrl: uploadUrl,
				uploadFileUrl: uploadFileUrl,
				//新增界面数据
				addFormVisible: false,//新增界面是否显示
				addLoading: false, //loading
				//数据
				addForm: {},
				//效验
				addFormRules: {
					type: [
						{  required: true, message: '请选择分类', trigger: 'blur' }
					]
				},
				//编辑界面数据
				editFormVisible: false,//编辑界面是否显示
				editLoading: false, //loading
				//数据
				editForm: {},
				//效验
				editFormRules: {
					type: [
						{  required: true, message: '请选择分类', trigger: 'blur' }
					]
					
				},
				//查看界面数据
				viewFormVisible: false,//编辑界面是否显示
				//数据
				viewForm: {},
				
				end: ''
			}
		},
		methods: {
			formatDate: function(date){
				return parent.window.formatDate(date, 'yyyy-MM-dd HH:mm:ss');
			},
			typeFormatter: function(row){
				var name = row.type;
				for (var i = 0; i < this.typeOptions.length; i++) {
					var item = this.typeOptions[i];
					if(row.type == item.pid){
						name = item.name;
						break
					}
				}
				return name;
			},
			handleFileUpload: function(res, file, obj, key){
				if(res.code > 0){
					this[obj][key] = res.data.path;
				}else{
					this.$message({
						message: res.msg,
						type: 'warning'
					});
				}
			},
			handleAddUpload: function(res){
				if(res.code > 0){
					this.addForm.pic = res.data.path;
				}else{
					this.$message({
						message: res.msg,
						type: 'warning'
					});
				}
			},
			handleEditUpload: function(res){
				if(res.code > 0){
					this.editForm.pic = res.data.path;
				}else{
					this.$message({
						message: res.msg,
						type: 'warning'
					});
				}
			},
			handleTypeOptions: function(cb){
				var self = this;
				var params = {};
				ajaxReq(typeUrl, params, function(res){
					if(res.code > 0){
						self.typeOptions = res.data;
						if(typeof cb == 'function'){
							cb();
						}
					}else{
						self.$message({
							message: res.msg,
							type: 'warning'
						})
					}
				});
			},
			handleAddTypeChange: function(){
				for (var i = 0; i < this.typeOptions.length; i++) {
					var item = this.typeOptions[i];
					if(this.addForm.type == item.pid){
						this.addForm.mark = item.mark;
						this.addForm = Object.assign(this.addForm, {
								ogg: '',
								mp4: '',
								webm: '',
								flash: '',
								video: '',
								mp3: '',
								wav: '',
								audio: ''
						});
						break
					}
				}
			},
			handleEditTypeChange: function(){
				for (var i = 0; i < this.typeOptions.length; i++) {
					var item = this.typeOptions[i];
					if(this.editForm.type == item.pid){
						this.editForm.mark = item.mark;
						this.editForm = Object.assign(this.editForm, {
								ogg: '',
								mp4: '',
								webm: '',
								flash: '',
								video: '',
								mp3: '',
								wav: '',
								audio: ''
						});
						break
					}
				}
			},
			handleSizeChange: function (val) {
				this.rows = val;
				this.getList();
			},
			handleCurrentChange: function (val) {
				this.page = val;
				this.getList();
			},
			//查询
			getList: function () {
				var self = this;
				var params = {
					page: this.page,
					rows: this.rows
				};
				for ( var key in this.filters) {
					if(this.filters[key] || this.filters[key] === 0){
						params[key] = this.filters[key];
					}
				}
				this.listLoading = true;
				ajaxReq(queryUrl, params, function(res){
					self.listLoading = false;
					if(res.code > 0){
						self.total = res.total;
						self.list = res.data;
						//不够一页，回退一页
						if(self.page != 1 && self.total <= (self.page - 1) * self.rows){
							self.page = self.page - 1;
							self.getList();
						}
					}else{
						self.$message({
							message: res.msg,
							type: 'warning'
						})
					}
				});
			},
			//显示新增界面
			handleAdd: function () {
				this.addFormVisible = true;
				this.addForm = {
						type: '',
						name: '',
						pic: '',
						mark: 0,
						status: 0,
						recommend: 0,
						highlight: 0,
						sort: 999,
						author: '',
						description: '',
						down: '',
						ogg: '',
						mp4: '',
						webm: '',
						flash: '',
						video: '',
						mp3: '',
						wav: '',
						audio: '',
						size: 0
				};
			},
			//显示编辑界面
			handleEdit: function (index, row) {
				this.editFormVisible = true;
				this.editForm = Object.assign({}, row);
			},
			//显示查看界面
			handleView: function (index, row) {
				this.viewFormVisible = true;
				this.viewForm = Object.assign({}, row);
			},
			//删除
			handleDel: function (index, row) {
				this.$confirm('确认删除该记录吗？删除后不可恢复。', '提示', {
					type: 'warning'
				}).then(() => {
					var self = this;
					this.listLoading = true;
					ajaxReq(delUrl, {pid: row.pid }, function(res){
						self.listLoading = false;
						if(res.code > 0){
							self.$message({
								message: '删除成功',
								type: 'success'
							});
							self.getList();
						}else{
							self.$message({
								message: res.msg,
								type: 'warning'
							})
						}
					});
					
				}).catch(() => {
				});
			},
			//新增
			addClose: function () {
				this.addFormVisible = false;
				this.addLoading = false;
				this.$refs.addForm.resetFields();
			},
			addSubmit: function () {
				this.$refs.addForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							var params = Object.assign({}, this.addForm);
							var self = this;
							this.addLoading = true;
							ajaxReq(addUrl, params, function(res){
								self.addLoading = false;
								if(res.code > 0){
									self.$message({
										message: '新增成功',
										type: 'success'
									});
									self.addFormVisible = false;
									self.getList();
								}else{
									self.$message({
										message: res.msg,
										type: 'warning'
									})
								}
							});
						});
					}
				});
			},
			//编辑
			editClose: function () {
				this.editFormVisible = false;
				this.editLoading = false;
				this.$refs.editForm.resetFields();
			},
			editSubmit: function () {
				this.$refs.editForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							var self = this;
							this.editLoading = true;
							var params = Object.assign({}, this.editForm);
							ajaxReq(modUrl, params, function(res){
								self.editLoading = false;
								if(res.code > 0){
									self.$message({
										message: '提交成功',
										type: 'success'
									});
									self.editFormVisible = false;
									self.getList();
								}else{
									self.$message({
										message: res.msg,
										type: 'warning'
									})
								}
							});
							
						});
					}
				});
			},
			selsChange: function (sels) {
				this.sels = sels;
			}
		},
		mounted: function() {
			this.handleTypeOptions();
			this.getList();
		}
	  });
	


