<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<div class="page-header">
	<h1>Packages</h1>
</div>

<div class="row">
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-list"></span> Packages
				</h3>
			</div>
			<div class="panel-body">
				<table id="package-table" class="table table-striped table-bordered" cellspacing="0" width="100%">
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
	        	{packages}
	            <tr>
	                <td>{name}</td>
	                <td>{date}</td>
	                <td>
	                	<a class="btn btn-primary btn-sm" href="<?php echo site_url('member/package/{id}'); ?>" target="package_view" data-toggle="tooltip" data-placement="top" title="View in Package Viewer"><span class="glyphicon glyphicon-eye-open"></span> View
                        </a>
                    </td>
	            </tr>
	            {/packages}
	        </tbody>
	    </table>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<div class="pull-right btn-group">
					<a id="package-fullsize" href="" target="_blank" class="btn btn-primary btn-xs"  data-toggle="tooltip" data-placement="top" title="View Fullscreen"><span class="glyphicon glyphicon-resize-full"></span></a>
					<a id="package-refresh" href="" target="package_view" class="btn btn-warning btn-xs"  data-toggle="tooltip" data-placement="top" title="Reload"><span class="glyphicon glyphicon-refresh"></span></a>
				</div>
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-eye-open"></span> Package Viewer
				</h3>
			</div>
			<div class="panel-body">
				<iframe id="package-view" name="package_view" src="" frameborder="0" width="100%" height="500"></iframe>
			</div>
		</div>
	</div>
</div>