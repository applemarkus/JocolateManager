<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<div class="page-header">
	<h1>Bills</h1>
</div>

<div class="row">
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-list"></span> Bills
				</h3>
			</div>
			<div class="panel-body">
				<table id="bills-table" class="table table-striped table-bordered" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>Name</th>
	                <th>Date</th>
	                <th>Options</th>
	            </tr>
	        </thead>
	 
	        <tfoot>
	            <tr>
	                <th>Name</th>
	                <th>Date</th>
	                <th>Options</th>
	            </tr>
	        </tfoot>
	 
	        <tbody>
	            <tr>
	                <td>Bill #1</td>
	                <td>17.02.2015</td>
	                <td>
	                	<a class="btn btn-primary btn-sm" href="http://jocolate:25001/index.php/api/bill/?email=990f04d9c5327481a7af01111bdf32f0&pwd=b0e08a6df167ab1f243caa5eb1b7f2ac&id=16" target="bill_view" data-toggle="tooltip" data-placement="top" title="View in Bill Viewer"><span class="glyphicon glyphicon-eye-open"></span> View
                        </a>
                    </td>
	            </tr>
	            <tr>
	                <td>Bill #2</td>
	                <td>17.02.2015</td>
	                <td>
	                	<a class="btn btn-primary btn-sm" href="<?php echo site_url('api/index'); ?>" target="bill_view" data-toggle="tooltip" data-placement="top" title="View in Bill Viewer"><span class="glyphicon glyphicon-eye-open"></span> View
                        </a>
                    </td>
	            </tr>
	        </tbody>
	    </table>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<div class="pull-right btn-group">
					<a id="bill-fullsize" href="" target="_blank" class="btn btn-primary btn-xs"  data-toggle="tooltip" data-placement="top" title="View Fullscreen"><span class="glyphicon glyphicon-resize-full"></span></a>
					<a id="bill-refresh" href="" target="bill_view" class="btn btn-warning btn-xs"  data-toggle="tooltip" data-placement="top" title="Reload"><span class="glyphicon glyphicon-refresh"></span></a>
				</div>
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-eye-open"></span> Bill Viewer
				</h3>
			</div>
			<div class="panel-body">
				<iframe id="bill-view" name="bill_view" src="" frameborder="0" width="100%" height="500"></iframe>
			</div>
		</div>
	</div>
</div>